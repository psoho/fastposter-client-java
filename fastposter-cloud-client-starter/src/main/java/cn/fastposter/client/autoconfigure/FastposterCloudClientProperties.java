package cn.fastposter.client.autoconfigure;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring boot starter properties
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.cn/"></>
 */
@Data
@Setter
@ConfigurationProperties("fastposter-cloud")
public class FastposterCloudClientProperties {

    /**
     * 接入点
     */
    String endpoint = "https://cloud.prodapi.cn";

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
