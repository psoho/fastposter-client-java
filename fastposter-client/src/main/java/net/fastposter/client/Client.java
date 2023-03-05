package net.fastposter.client;

import okhttp3.OkHttpClient;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * 客户端
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://cloud.fastposter.net/doc/sdk/java.html"></>
 */
public interface Client {
    /**
     * 客户端类型
     */
    String CLIENT_TYPE = "java";
    /**
     * 客户端版号
     */
    String CLIENT_VERSION = "1.7.0";
    /**
     * 日期格式
     */
    SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    /**
     * 云服务接入点
     */
    String CLOUD_ENDPOINT = "https://api.fastposter.net";

    /**
     * 默认的OKHttp请求
     */
    OkHttpClient DEFAULT_OK_HTTP_CLIENT = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).build();

    /**
     * 构建海报生成器
     *
     * @param uuid
     * @return
     */
    PosterBuilder buildPoster(String uuid);

}
