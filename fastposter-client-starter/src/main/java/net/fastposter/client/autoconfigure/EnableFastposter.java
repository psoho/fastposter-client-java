package net.fastposter.client.autoconfigure;

import net.fastposter.client.FastposterClient;
import net.fastposter.client.FastposterCloudClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

/**
 * EnableFastposter
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://cloud.fastposter.net/doc/sdk/java.html"></>
 */
@Import(FastposterClientAutoConfiguration.class)
public class EnableFastposter {

}
