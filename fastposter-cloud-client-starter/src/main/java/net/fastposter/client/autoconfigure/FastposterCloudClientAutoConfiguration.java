package net.fastposter.client.autoconfigure;

import net.fastposter.client.FastposterCloudClient;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * FastposterCloudClient AutoConfiguration
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://cloud.fastposter.net/doc/"></>
 */
@Configuration
@AllArgsConstructor
@ComponentScan(basePackages = {"net.fastposter.client"})
@EnableConfigurationProperties(FastposterCloudClientProperties.class)
@ConditionalOnProperty("fastposter-cloud.app-key")
public class FastposterCloudClientAutoConfiguration {

    private final FastposterCloudClientProperties properties;

    @Bean
    FastposterCloudClient fastposterCloudClient() {
        return FastposterCloudClient.builder()
                .appKey(properties.getAppKey())
                .appSecret(properties.getAppSecret())
                .endpoint(properties.getEndpoint())
                .debug(properties.isDebug())
                .trace(properties.isTrace())
                .build();
    }

}
