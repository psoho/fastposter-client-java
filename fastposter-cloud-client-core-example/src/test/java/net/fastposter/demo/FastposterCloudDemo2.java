package net.fastposter.demo;import net.fastposter.client.FastposterCloudClient;public class FastposterCloudDemo2 {    public static void main(String[] args) {        // 创建海报客户端对象        FastposterCloudClient client = FastposterCloudClient.builder()                .appKey("1f5aa8d75f2d4bc4")                .appSecret("8a395182a41e41ad9318cea4e1018cdc")                .debug(true)                .build();        // 准备海报参数        // 生成海报并保存        client.buildPoster("ced9b1d5337d494c")                .put("name", "测试文阿斯顿发大水范德萨本")                .pdf()                .build().save();    }}