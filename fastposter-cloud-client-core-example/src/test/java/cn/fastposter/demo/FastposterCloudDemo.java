package cn.fastposter.demo;import cn.fastposter.cloud.client.FastposterCloudClient;import java.util.HashMap;import java.util.Map;public class FastposterCloudDemo {    public static void main(String[] args) {        // 创建海报客户端对象        FastposterCloudClient client = FastposterCloudClient.builder()                .endpoint("https://api.fastposter.net")                .appKey("1f5aa8d75f2d4bc4")                .appSecret("8a395182a41e41ad9318cea4e1018cdc")                .debug(true)                .build();        // 准备海报参数        Map<String, Object> params = new HashMap<>();        params.put("name", "测试文阿斯顿发大水范德萨本");        // 生成海报并保存//        client.buildPoster("ced9b1d5337d494c")        client.buildPoster("c61a34f356de4b32")                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")                .params(params).build().save();    }}