package com.example;import net.fastposter.client.FastposterCloudClient;import java.util.HashMap;import java.util.Map;public class FastposterCloudDemo2 {    public static void main(String[] args) {        // 创建海报客户端对象        FastposterCloudClient client = FastposterCloudClient.builder()                .appKey("60800b6e8afe45ff")                .appSecret("7303dc4e5efe4485b58e3007516e5987")                .debug(true)                .build();        // 准备海报参数        Map<String, Object> params = new HashMap<>();//        params.put("name", "中文测试");        for (int i = 0; i < 1000; i++) {            // 生成海报并保存            params.put("name", "中文测试打发打发" + i);            client.buildPoster("63889538e2ea4328").params(params).build();        }    }}