package cn.fastposter.demo;

import cn.fastposter.cloud.client.FastposterCloudClient;
import cn.fastposter.cloud.client.Poster;
import cn.fastposter.cloud.client.PosterType;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoTests {

    @Autowired
    FastposterCloudClient client;

    Map<String, String> params;

    @BeforeEach
    void before() {
        // 构造海报参数
        params = new HashMap<>();
        // 暂未指定任何动态参数
        params.put("day", "5");
    }

    @Test
    void testPng() {
        Poster p = client.buildPoster(100004, params, PosterType.png);
        p.save();
    }

    @Test
    void testJpeg() {
        Poster p = client.buildPoster(100004, params, PosterType.valueOf("jpeg"));
    }

    @Test
    void testJpegAndScale() {
        Poster p = client.buildPoster(100004, params, PosterType.jpeg, 0.5);
    }

    @Test
    void testWebp() {
        Poster p = client.buildPoster(100004, params, PosterType.webp);
    }

    @SneakyThrows
    @Test
    void testPdfSave() {
        Poster p = client.buildPoster(100004, params, PosterType.pdf);
        p.save("a.pdf");
    }

    @SneakyThrows
    @Test
    void testPdf() {
        Poster p = client.buildPoster(100004, params, PosterType.pdf);
        System.out.println(p.size());
        System.out.println(p.traceId());
    }

    @SneakyThrows
    @Test
    void testBase64() {
        Poster p = client.buildPoster(100004, params, PosterType.jpeg, true);
        String data = "<img style=\"width:300px;\" src=\"data:image/jpg;base64," + p.b64String() + "\"/>";
        FileUtils.writeStringToFile(new File("b64.html"), data, "utf-8");
    }


}
