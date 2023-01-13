package net.fastposter.client;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;


/**
 * 海报对象
 * <p>
 * 可以通过此对象获取图片的字节数组，字节流，base64编码等。
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.net/"></>
 */
public class Poster {

    PosterType type;

    private byte[] _bytes;

    String traceId;

    long size;

    boolean b64;

    protected Poster(String traceId, PosterType type, byte[] bytes, Boolean b64) {
        this.type = type;
        this.traceId = traceId;
        this._bytes = bytes;
        this.b64 = b64 != null && b64;
    }

    /**
     * 获取海报的字节数组
     *
     * @return
     */
    @SneakyThrows
    public byte[] bytes() {
        return _bytes;
    }

    /**
     * 保存海报到指定目录
     *
     * @param path
     */
    @SneakyThrows
    public void save(String path) {
        FileUtils.writeByteArrayToFile(new File(path), bytes());
    }

    /**
     * 保存海报
     *
     * @return
     */
    public String save() {
        String path = traceId.substring(0, 16) + "." + type;
        if (b64) {
            path += ".b64";
        }
        save(path);
        return path;
    }

    /**
     * 海报大小 字节
     *
     * @return
     */
    public long size() {
        return this.size;
    }

    /**
     * 追踪ID
     *
     * @return
     */
    public String traceId() {
        return this.traceId;
    }

    /**
     * 返回Base64字符串
     *
     * @return
     */
    public String b64String() {
        return new String(bytes());
    }

    /**
     * 返回海报内存流
     *
     * @return
     */
    public InputStream byteStream() {
        return new ByteArrayInputStream(bytes());
    }

}
