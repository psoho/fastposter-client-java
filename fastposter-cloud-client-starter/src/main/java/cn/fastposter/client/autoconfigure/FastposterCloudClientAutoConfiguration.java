package cn.fastposter.client.autoconfigure;

import cn.fastposter.cloud.client.FastposterCloudClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * spring boot starter AutoConfiguration
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.cn/"></>
 */
@Configuration
@AllArgsConstructor
@ComponentScan(basePackages = {"cn.fastposter.client"})
@EnableConfigurationProperties(FastposterCloudClientProperties.class)
public class FastposterCloudClientAutoConfiguration {

    private final FastposterCloudClientProperties properties;

    @Bean
    @ConditionalOnProperty("fastposter-cloud.app-key")
    FastposterCloudClient fastposterCloudClient() {
        return FastposterCloudClient.builder()
                .appKey(properties.appKey)
                .appSecret(properties.appSecret)
                .endpoint(properties.endpoint)
                .debug(properties.debug)
                .trace(properties.trace)
                .build();
    }

}
