package net.fastposter.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

/**
 * Json工具类
 * <p>
 *
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.net/"></>
 */
public class JsonUtils {

    /**
     * 转换成Json
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
