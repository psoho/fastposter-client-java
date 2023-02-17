package net.fastposter.client;import com.fasterxml.jackson.annotation.JsonIgnoreProperties;import lombok.Builder;import lombok.Data;import lombok.SneakyThrows;import net.fastposter.client.utils.*;import okhttp3.*;import java.util.Date;import java.util.Map;import java.util.Objects;import java.util.concurrent.TimeUnit;import java.util.concurrent.atomic.AtomicLong;/** * fastposter云服务客户端 * * @author Alex小新 fastposter@163.com * @see <a href="https://cloud.fastposter.net/doc/"></> */@Builderpublic class FastposterClient implements Client, Buildable {    @Builder.Default    private OkHttpClient okHttpClient;    @Builder.Default    private String endpoint = "http://127.0.0.1:5000";    private String token;    private String appKey;    private String appSecret;    private boolean debug;    private boolean trace;    @Builder.Default    private AtomicLong atomicLong = new AtomicLong(0);    @SneakyThrows    private <T> T buildPoster(String uuid, Map<String, Object> params, PosterType type, Double scale, Boolean b64, String userAgent, boolean onlySign) {        long time = System.currentTimeMillis();        long seq = atomicLong.incrementAndGet();        String data = JsonUtils.toJson(params);        // base64编码        String payload = Base64Utils.encodeToString(data.getBytes());//        String payload=  data;        // 计算签名        Long timestamp = System.currentTimeMillis() / 1000;        String nonce = RandomUtils.randomAlphanumeric(16);//        String sign = DigestUtils.md5DigestAsHex((playload + timestamp + nonce + appSecret).getBytes());        // 构建请求参数        GetPosterArgs.GetPosterArgsBuilder build = GetPosterArgs.builder()                .uuid(uuid)                .b64(b64)                .scale(scale)                .timestamp(timestamp)                .nonce(nonce)                .appKey(appKey)//                .sign(sign)                .payload(payload);        if (type != null) {            build.type(type.value);        }        GetPosterArgs args = build.build();        String url = this.endpoint + "/v1/build/poster";        MediaType mediaType = MediaType.parse("application/json");        String json = JsonUtils.toJson(args);        if (onlySign) {            return (T) args;        }        debug = trace ? true : debug;        if (trace) {            System.out.println(SDF.format(new Date()) + " " + seq + " build poster url=" + url + ", request=" + json);        }        userAgent = userAgent != null && userAgent.length() > 1 ? userAgent : "";        RequestBody body = RequestBody.create(json, mediaType);        Request request = new Request.Builder().url(url).post(body)                .addHeader("User-Agent", userAgent)                .addHeader("token", token)                .addHeader("Content-Type", "application/json")                .addHeader("cache-control", "no-cache").build();        Response response = okHttpClient().newCall(request).execute();        String traceId = response.header("fastposter-traceid", "none");        if (trace) {            response.headers().forEach(a -> System.out.println(a.getFirst() + ":" + a.getSecond()));        }        if (response.code() != 200) {            throw new FastpsoterException(seq, response.code(), " build poster error! \n" + response.body().string(), traceId);        }        String contentType = response.header("content-type");        if (contentType != null && contentType.contains("application/json")) {            assert response.body() != null;            PosterResponse pr = JsonUtils.parseObject(response.body().bytes(), PosterResponse.class);            if (pr.code != 0) {                throw new FastpsoterException(seq, pr.code, pr.getMsg(), traceId);            }            return null;        }        assert response.body() != null;        byte[] bytes = response.body().bytes();        long size = bytes.length;        if (type == null) {            // 获取服务器返回的图片类型            String rcontentType = response.header("Content-Type");            if (rcontentType != null && !Objects.equals(contentType, "")) {                if (rcontentType.contains("jpeg")) {                    type = PosterType.jpeg;                } else if (rcontentType.contains("pdf")) {                    type = PosterType.pdf;                } else if (rcontentType.contains("png")) {                    type = PosterType.png;                } else if (rcontentType.contains("jpg")) {                    type = PosterType.jpg;                } else {                    type = PosterType.jpg;                }            } else {                type = PosterType.jpg;            }        }        if (debug) {            time = System.currentTimeMillis() - time;            System.out.println(SDF.format(new Date()) + " " + seq + " build poster completed. traceId=" + traceId + " uuid=" + uuid + " type=" + type + " " + (type.value.length() <= 3 ? " " : "") + "size=" + size + " rt=" + time + "ms" + (b64 != null && b64 ? " b64=" + b64 : "") + (scale != null ? " scale=" + scale : ""));        }        return (T) new Poster(traceId, type, bytes, b64);    }    private OkHttpClient okHttpClient() {        if (this.okHttpClient == null) {            this.okHttpClient = DEFAULT_OK_HTTP_CLIENT;        }        return okHttpClient;    }    /**     * 生成海报     *     * @param uuid 海报UUID     * @return 海报生成器     */    public PosterBuilder buildPoster(String uuid) {        return PosterBuilder.builder().client(this).uuid(uuid).build();    }    /**     * 通过PosterBuilder生成海报     *     * @param posterBuilder 海报构造器     * @return 海报对象     */    @Override    public Poster build(PosterBuilder posterBuilder) {        return buildPoster(posterBuilder.uuid, posterBuilder.params, posterBuilder.type, posterBuilder.scale, posterBuilder.b64, posterBuilder.userAgent, false);    }    /**     * 生成签名     *     * @param posterBuilder     * @return     */    @Override    public GetPosterArgs getArgs(PosterBuilder posterBuilder) {        return buildPoster(posterBuilder.uuid, posterBuilder.params, posterBuilder.type, posterBuilder.scale, posterBuilder.b64, posterBuilder.userAgent, true);    }    @Data    @JsonIgnoreProperties(ignoreUnknown = true)    static class PosterResponse {        int code;        String msg;        Object data;        String traceId;    }}