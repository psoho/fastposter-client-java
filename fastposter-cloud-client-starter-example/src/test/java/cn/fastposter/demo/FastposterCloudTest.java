package cn.fastposter.demo;

import cn.fastposter.cloud.client.FastposterCloudClient;
import cn.fastposter.cloud.client.Poster;
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
        Map<String, String> params = new HashMap<>();
        params.put("name", "测试文本");
        Poster p = client.buildPoster("", params);
//        p.save(); // 保存海报
        p.bytes();  // 返回字节数组
        p.byteStream(); // 返回字节流
    }


}
