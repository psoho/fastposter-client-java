package net.fastposter.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import net.fastposter.client.FastposterCloudClient;

/**
 * Json工具类
 * <p>
 *
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://fastposter.net/doc/sdk/java.html"></>
 */
public class JsonUtils {

    /**
     * 转换成Json字符串
     *
     * @param value 对象
     * @return 字符串
     */
    @SneakyThrows
    public static String toJson(Object value) {
        String data = new ObjectMapper().writeValueAsString(value);
        return data;
    }


    /**
     * 转换成Json字符串
     *
     * @param value 对象
     * @return 字符串
     */
    @SneakyThrows
    public static String toPrettyJson(Object value) {
        String data = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(value);
        return data;
    }

    /**
     * 解析JSON字符串为一个对象
     *
     * @param value 字节数组
     * @param type  对象类型
     * @return 对象
     */
    @SneakyThrows
    public static <T> T parseObject(byte[] value, Class<T> type) {
        return new ObjectMapper().readValue(value, type);
    }

}
