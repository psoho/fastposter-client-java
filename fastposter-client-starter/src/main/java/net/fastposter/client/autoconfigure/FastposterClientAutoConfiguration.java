package net.fastposter.client.autoconfigure;

import lombok.AllArgsConstructor;
import net.fastposter.client.FastposterClient;
import net.fastposter.client.FastposterCloudClient;
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
@EnableConfigurationProperties(FastposterClientProperties.class)
//@ConditionalOnProperty("fastposter.appKey")
public class FastposterClientAutoConfiguration {

    private final FastposterClientProperties properties;
//
//    @Bean
////    @ConditionalOnProperty(value = "fastposter.appKey")
//    FastposterCloudClient fastposterCloudClient() {
//        return FastposterCloudClient.builder()
//                .appKey(properties.getAppKey())
//                .appSecret(properties.getAppSecret())
//                .endpoint(properties.getEndpoint())
//                .debug(properties.isDebug())
//                .trace(properties.isTrace())
//                .build();
//    }


    @Bean
//    @ConditionalOnProperty(value = "fastposter.token")
    FastposterClient fastposterClient() {
        return FastposterClient.builder()
                .endpoint(properties.getEndpoint())
                .token(properties.getToken())
                .debug(properties.isDebug())
                .trace(properties.isTrace())
                .build();
    }

}
