package cn.fastposter.demo;

import cn.fastposter.cloud.client.FastposterCloudClient;
import cn.fastposter.cloud.client.Poster;
import cn.fastposter.cloud.client.PosterType;
import javafx.geometry.Pos;
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
        Map<String, Object> params = new HashMap<>();
        params.put("name", "测试文本");

        client.buildPoster("2a72b451834d4c59")
                .b64()
                .png()
                .type("png")
                .add("name", "你好")
                .build()
                .save();

    }


}
