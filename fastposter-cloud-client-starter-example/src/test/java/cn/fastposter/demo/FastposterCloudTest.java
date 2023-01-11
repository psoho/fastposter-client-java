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
//        params.put("name", "无敌");
//        params.put("age", 100);

        // 生成海报并保存
        client.buildPoster("2a72b451834d4c59").setParams(params).build().save();

    }

}
