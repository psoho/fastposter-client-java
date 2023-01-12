package cn.fastposter.demo;

import cn.fastposter.cloud.client.FastposterCloudClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FastposterCloudTest {

    @Autowired
    FastposterCloudClient client;

    @Test
    void testPng() {

        // 获取参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", 100);

        // 生成海报并保存
        client.buildPoster("ced9b1d5337d494c").params(params).build().save();

    }

}
