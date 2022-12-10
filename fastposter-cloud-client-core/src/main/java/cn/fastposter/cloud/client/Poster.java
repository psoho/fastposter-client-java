package cn.fastposter.cloud.client;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FilterInputStream;
import java.io.InputStream;


/**
 * 生成海报对象，对象本身是一个输入流，可以直接读取。
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.cn/"></>
 */
public class Poster extends FilterInputStream {

    PosterType type;

    private byte[] _bytes;

    String traceId;

    long size;

    public Poster(String traceId, PosterType type, InputStream in, long size) {
        super(in);
        this.type = type;
        this.traceId = traceId;
        this.size = size;
    }

    /**
     * 获取海报的字节数组
     *
     * @return
     */
    @SneakyThrows
    public byte[] bytes() {
        if (_bytes == null) {
            _bytes = IOUtils.toByteArray(this);
        }
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
     */
    public void save() {
        save(traceId.substring(0, 16) + "." + type);
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

}
