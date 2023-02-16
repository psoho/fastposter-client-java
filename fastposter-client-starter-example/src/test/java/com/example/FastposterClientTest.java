package com.example;

import net.fastposter.client.FastposterClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FastposterClientTest {

    @Autowired
    FastposterClient client;

    @Test
    void testPng() {

        // 组装参数
        Map<String, Object> params = new HashMap<>();
        params.put("title", "中文测试");
        // 生成海报并保存
        client.buildPoster("80058c79d1e2e617").params(params).build().save();

    }

}
