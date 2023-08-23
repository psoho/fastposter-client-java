package net.fastposter.client.autoconfigure;

import lombok.Data;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * spring boot starter properties
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://fastposter.net/doc/sdk/java.html"></>
 */
@Data
@Setter
@ConfigurationProperties("fastposter")
public class FastposterClientProperties {

    /**
     * 接入点
     */
    private String endpoint = "https://api.fastposter.net";

    /**
     * appKey
     */
    private String appKey;

    /**
     * appSecret
     */
    private String appSecret;

    /**
     * 是否打开调试
     */
    private boolean debug;

    /**
     * 是否打开追踪
     */
    private boolean trace;

    /**
     * 社区版token
     */
    private String token;

}
