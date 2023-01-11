package cn.fastposter.cloud.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

/**
 * Json工具类
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.net/"></>
 */
public class JsonUtils {

    /**
     * @param value
     * @return
     */
    @SneakyThrows
    public static String toJson(Object value) {
        String data = new ObjectMapper().writeValueAsString(value);
        return data;
    }

    @SneakyThrows
    public static <T> T parseObject(byte[] value, Class<T> type) {
        return new ObjectMapper().readValue(value, type);
    }
}
