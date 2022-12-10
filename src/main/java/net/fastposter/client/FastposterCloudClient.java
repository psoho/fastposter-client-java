package net.fastposter.client;import lombok.Builder;import lombok.Data;import lombok.SneakyThrows;import net.fastposter.client.utils.Base64Utils;import net.fastposter.client.utils.DigestUtils;import net.fastposter.client.utils.JsonUtils;import okhttp3.*;import java.text.SimpleDateFormat;import java.util.Date;import java.util.Map;import java.util.concurrent.TimeUnit;@Data@Builderpublic class FastposterCloudClient {    private static final String USER_AGENT = "fastposter-cloud-client/java:v1.0.0";    private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");    OkHttpClient okHttpClient;    String endpoint;    String appKey;    String appSecret;    boolean debug;    boolean trace;    public byte[] buildPoster(Integer id, Map<String, String> params) {        return buildPoster(id, params, null);    }    public byte[] buildPoster(Integer id, Map<String, String> params, PosterType type) {        return buildPoster(id, params, type, false);    }    @SneakyThrows    public byte[] buildPoster(Integer id, Map<String, String> params, PosterType type, boolean b64) {        long time = System.currentTimeMillis();        String data = JsonUtils.toJson(params);        // base64编码        String playload = Base64Utils.encodeToUrlSafeString(data.getBytes());        // 计算签名        String sign = DigestUtils.md5DigestAsHex((playload + appSecret).getBytes());        // 构建请求参数        GetPosterArgs args = GetPosterArgs.builder()                .id(id)                .type(type.value)                .b64(b64)                .appKey(appKey)                .sign(sign)                .payload(playload)                .build();        String url = this.endpoint + "/v1/api/build/poster";        MediaType mediaType = MediaType.parse("application/json");        String json = JsonUtils.toJson(args);        RequestBody body = RequestBody.create(json, mediaType);        Request request = new Request.Builder()                .url(url)                .post(body)                .addHeader("User-Agent", USER_AGENT)                .addHeader("Content-Type", "application/json")                .addHeader("cache-control", "no-cache")                .build();        Response response = okHttpClient().newCall(request).execute();        if (trace) {            response.headers().forEach(a -> System.out.println(a.getFirst() + ":" + a.getSecond()));        }        if (response.code() != 200) {            System.err.println("code=" + response.code());            throw new RuntimeException("build poster error!\n" + response.body().string());        }        String contentType = response.header("content-type");        if ("application/json".equals(contentType)) {            assert response.body() != null;            PosterResponse pr = JsonUtils.parseObject(response.body().bytes(), PosterResponse.class);            if (pr.code != 0) {                throw new RuntimeException("build poster error!\n" + pr.getMsg());            }            return null;        }        assert response.body() != null;        byte[] bytes = response.body().bytes();        if (debug) {            time = System.currentTimeMillis() - time;            String expendTime = response.header("fastposter-cloud-expend-time");            String traceId = response.header("fastposter-cloud-traceid");            System.out.println(SDF.format(new Date()) + " poster build completed. traceId=" + traceId + " posterId=" + id + ", type=" + type + ", size=" + bytes.length + ", et=" + expendTime + ", rt=" + time + "ms" + ", b64=" + b64);        }        return bytes;    }    private OkHttpClient okHttpClient() {        if (this.okHttpClient == null) {            this.okHttpClient = new OkHttpClient.Builder()                    .connectTimeout(6, TimeUnit.SECONDS)                    .build();        }        return okHttpClient;    }    @Data    static class PosterResponse {        int code;        String msg;        Object data;    }}