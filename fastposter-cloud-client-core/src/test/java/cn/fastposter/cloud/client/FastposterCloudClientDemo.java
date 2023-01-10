package cn.fastposter.cloud.client;import lombok.SneakyThrows;import okhttp3.OkHttpClient;import okhttp3.tls.HandshakeCertificates;import org.apache.commons.io.FileUtils;import org.apache.commons.io.IOUtils;import java.io.File;import java.io.FileOutputStream;import java.util.HashMap;import java.util.Map;/** * 测试 * * @author Alex小新 fastposter@163.com * @site <a href="https://cloud.fastposter.net/"></> */public class FastposterCloudClientDemo {    @SneakyThrows    public static void main(String[] args) {        // 创建海报客户端对象        FastposterCloudClient client = FastposterCloudClient.builder()                .endpoint("https://api.fastposter.net")//                .okHttpClient(newOkHttpClient())//                .appKey("e1adbc73958646fe")//                .appSecret("dea7aea213de4488a5504d040c124b49")                .appKey("793677ac5def45d4")                .appSecret("214fe52955464947a9eb70bff9d23770")                .debug(true)//                .trace(true)      // 跟踪模式                .build();        // 构造海报参数        Map<String, String> params = new HashMap<>();        // 暂未指定任何动态参数        params.put("day", "8");//        for (int i = 0; i < 100; i++) {//            // 获取下载地址//            Poster p = client.buildPoster(100004, params, PosterType.png);//            Poster p1 = client.buildPoster(100004, params, PosterType.jpeg);//        }//        Integer posterId = 100004;        Integer posterId = 100007;        // 获取下载地址        Poster p = client.buildPoster(posterId, params, PosterType.png);        Poster p0 = client.buildPoster(posterId, params, PosterType.jpeg);//        Poster p1 = client.buildPoster(posterId, params, PosterType.jpeg, 0.5);//        Poster p2 = client.buildPoster(posterId, params, PosterType.webp);        Poster p3 = client.buildPoster(posterId, params, PosterType.jpeg, true);//        Poster p31 = client.buildPoster(posterId, params, PosterType.png, true);//        Poster p4 = client.buildPoster(posterId, params, PosterType.pdf);        // base64测试        String b64 = new String(p3.bytes());//        System.out.println(b64);        p.save("aaa.png");        p.save();        IOUtils.copy(p0.byteStream(), new FileOutputStream("xxxxx.png"));        // 验证//        String data = "<img src=\"data:image/jpg;base64," + b64 + "\"/>";        String data = "<html><body><img style=\"width:200px;\" src=\"data:image/jpeg;base64," + b64 + "\"/></body></html>";        FileUtils.writeStringToFile(new File("b64.html"), data, "utf-8");        System.out.println("end");    }    /**     * 加载系统信任的证书     *     * @return     */    private static OkHttpClient newOkHttpClient() {        HandshakeCertificates certificates = new HandshakeCertificates.Builder()                .addPlatformTrustedCertificates()                .build();        OkHttpClient client = new OkHttpClient.Builder()                .sslSocketFactory(certificates.sslSocketFactory(), certificates.trustManager())                .build();        return client;    }}