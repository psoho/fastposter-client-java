package cn.fastposter.cloud.client;

import java.io.FilterInputStream;
import java.io.InputStream;



/**
 * 生成海报参数
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.cn/"></>
 */
public class Poster extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected Poster(String type, InputStream in) {
        super(in);
    }



}
