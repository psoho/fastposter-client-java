package cn.fastposter.demo;

import cn.fastposter.cloud.client.FastposterCloudClient;
import cn.fastposter.cloud.client.Poster;
import cn.fastposter.cloud.client.PosterType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoTests {

    @Autowired
    FastposterCloudClient client;

    Map<String, String> params;

    String uuid = "";

    @BeforeEach
    void before() {
        // 构造海报参数
        params = new HashMap<>();
        // 暂未指定任何动态参数
        params.put("day", "5");
    }

    @Test
    @RepeatedTest(20)
//    @Disabled
    void testPng() throws IOException {
        Poster p = client.buildPoster(uuid, params, PosterType.png);
//        p.save();
    }

    @Test
    void testJpeg() {
        Poster p = client.buildPoster(uuid, params, PosterType.valueOf("jpeg"));
        p.save("aaa.jpeg");
    }

    @Test
    void testJpegAndScale() {
        Poster p = client.buildPoster(uuid, params, PosterType.jpeg, 0.5);
    }

    @Test
    void testWebp() {
        Poster p = client.buildPoster(uuid, params, PosterType.webp);
    }

    @SneakyThrows
    @Test
    @Disabled
    void testPdfSave() {
        Poster p = client.buildPoster(uuid, params, PosterType.pdf);
        p.save("a.pdf");
    }

    @SneakyThrows
    @Test
    @Disabled
    void testPdf() {
        Poster p = client.buildPoster(uuid, params, PosterType.pdf);
        System.out.println(p.size());
        System.out.println(p.traceId());
    }

    @SneakyThrows
    @Test
//    @Disabled
    void testBase64() {
        Poster p = client.buildPoster(uuid, params, PosterType.jpeg, true);
        String data = "<img style=\"width:300px;\" src=\"data:image/jpg;base64," + p.b64String() + "\"/>";
//        FileUtils.writeStringToFile(new File("b64.html"), data, "utf-8");
    }


}
