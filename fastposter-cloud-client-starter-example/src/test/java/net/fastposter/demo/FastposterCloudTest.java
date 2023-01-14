package net.fastposter.demo;

import net.fastposter.client.FastposterCloudClient;
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

        // 组装参数
        Map<String, Object> params = new HashMap<>();
        params.put("name", "中文测试");

        // 生成海报并保存
//        client.buildPoster("d31ce9b1e3b14762").params(params).build().save();
        System.out.println(client.buildPoster("d31ce9b1e3b14762").params(params).getArgs());

    }

}
