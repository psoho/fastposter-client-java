package net.fastposter.client.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

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
