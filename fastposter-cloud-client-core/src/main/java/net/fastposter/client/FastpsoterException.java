package net.fastposter.client;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * fastposter云服务客户端异常类
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.net/"></>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FastpsoterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private String traceId;

    public FastpsoterException(int code, String msg, String traceId) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.traceId = traceId;
    }

}