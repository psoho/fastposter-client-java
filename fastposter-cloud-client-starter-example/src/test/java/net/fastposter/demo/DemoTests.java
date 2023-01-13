package net.fastposter.demo;

import net.fastposter.client.FastposterCloudClient;
import net.fastposter.client.Poster;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoTests {

    @Autowired
    FastposterCloudClient client;

    Map<String, Object> params;

    String uuid = "ced9b1d5337d494c";

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
    void testPng() {
        client.buildPoster(uuid).params(params).png().build().save();
    }

    @Test
    void testJpeg() {
        client.buildPoster(uuid).params(params).jpeg().build().save();
    }

    @Test
    void testJpegAndScale() {
        client.buildPoster(uuid).params(params).scale(0.5).build().save();
    }

    @Test
    void testWebp() {
        client.buildPoster(uuid).params(params).webp().build().save();
    }

    @SneakyThrows
    @Test
    @Disabled
    void testPdfSave() {
        client.buildPoster(uuid).params(params).pdf().build().save();
    }

    @SneakyThrows
    @Test
    @Disabled
    void testPdf() {
        Poster p = client.buildPoster(uuid).params(params).pdf().build();
        System.out.println(p.size());
        System.out.println(p.traceId());
    }

    @SneakyThrows
    @Test
//    @Disabled
    void testBase64() {
        Poster p = client.buildPoster(uuid).params(params).b64().build();
        String data = "<img style=\"width:300px;\" src=\"data:image/jpg;base64," + p.b64String() + "\"/>";
        FileUtils.writeStringToFile(new File("b64.html"), data, "utf-8");
    }


}
