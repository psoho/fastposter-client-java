package cn.fastposter.demo;

import cn.fastposter.cloud.client.FastposterCloudClient;
import cn.fastposter.cloud.client.Poster;
import cn.fastposter.cloud.client.PosterType;
import lombok.SneakyThrows;
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
        Poster px = client.buildPoster(100004, params, PosterType.valueOf("jpeg"));
    }

    @Test
    void testJpegAndScale() {
        Poster px = client.buildPoster(100004, params, PosterType.jpeg, 0.5);
    }

    @Test
    void testWebp() {
        Poster px = client.buildPoster(100004, params, PosterType.webp);
    }

    @SneakyThrows
    @Test
    void testPdf() {
        Poster px = client.buildPoster(100004, params, PosterType.pdf);
        px.save("a.pdf");
    }

    @SneakyThrows
    @Test
    void testBase64() {
        Poster p3 = client.buildPoster(100004, params, PosterType.jpeg, true);
    }


}
