package net.fastposter.client.autoconfigure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableFastposter
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://fastposter.net/doc/sdk/java.html"></>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastposterClientAutoConfiguration.class)
public @interface EnableFastposter {

}
