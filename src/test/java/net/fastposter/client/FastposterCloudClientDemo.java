package net.fastposter.client;import java.util.HashMap;import java.util.Map;public class FastposterCloudClientDemo {    public static void main(String[] args) {        // 创建海报客户端对象        FastposterCloudClient client = FastposterCloudClient.builder()                .endpoint("https://cloud.prodapi.cn")                .appKey("demo")                .appSecret("demo")                .build();        // 构造海报参数        Map<String, String> params = new HashMap<>();        // 暂未指定任何动态参数        params.put("day", "7");        // 获取下载地址        byte[] p = client.buildPoster(100004, params, PosterType.png);        byte[] p1 = client.buildPoster(100004, params, PosterType.jpeg);//        byte[] p2 = client.buildPoster(100004, params, PosterType.webp);//        byte[] p3 = client.buildPoster(100004, params, PosterType.pdf);        System.out.println("end");    }}