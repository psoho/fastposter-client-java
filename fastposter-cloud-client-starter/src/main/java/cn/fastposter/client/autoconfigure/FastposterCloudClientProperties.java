package cn.fastposter.client.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring boot starter properties
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.cn/"></>
 */
@Data
@ConfigurationProperties("fastposter-cloud")
public class FastposterCloudClientProperties {

    /**
     * 接入点
     */
    String endpoint;

    /**
     * appKey
     */
    String appKey;

    /**
     * appSecret
     */
    String appSecret;

    /**
     * 是否打开调试
     */
    boolean debug;

    /**
     * 是否打开追踪
     */
    boolean trace;

}
