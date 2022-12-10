package cn.fastposter.cloud.client;

import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;


/**
 * 生成海报对象
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

    @SneakyThrows
    public byte[] bytes() {
        if (_bytes == null) {
            _bytes = IOUtils.toByteArray(this);
        }
        return _bytes;
    }

    @SneakyThrows
    public void save(String path) {
        FileUtils.writeByteArrayToFile(new File(path), bytes());
    }

    public void save() {
        save(traceId + "." + type);
    }

    public long size() {
        return this.size;
    }

    public String traceId() {
        return this.traceId;
    }
    
}
