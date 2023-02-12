package com.example;

import lombok.extern.slf4j.Slf4j;
import net.fastposter.client.FastposterCloudClient;
import net.fastposter.client.GetPosterArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class DemoController {

    @Autowired
    FastposterCloudClient client;

    @PostMapping("/fastposter/buildArgs/{uuid}")
    public GetPosterArgs buildArgs(@PathVariable("uuid") String uuid, @RequestBody Map<String, Object> params) {
        log.info("buildArgs: uuid={}, params={}", uuid, params);
        return client.buildPoster(uuid).params(params).getArgs();
    }

}
