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

        Poster p1 = client.buildPoster("uuid")
                .b64()
                .png()
                .type("png")
                .add("name", "测试文本")
                .add("name", "测试文本")
                .add("name", "测试文本")
                .build();

        System.out.println(p1.traceId());

////                .save("aaa.png");
//        Poster p = client.buildPoster("", params);
////        p.save(); // 保存海报
//        p.bytes();  // 返回字节数组
//        p.byteStream(); // 返回字节流
    }


}
