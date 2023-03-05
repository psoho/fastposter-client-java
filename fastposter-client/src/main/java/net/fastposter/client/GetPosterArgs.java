package net.fastposter.client;

import net.fastposter.client.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * 生成海报参数
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://cloud.fastposter.net/doc/sdk/java.html"></>
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPosterArgs {

    /**
     * 海报UUID
     */
    String uuid;

    /**
     * 海报类型
     */
    String type;

    /**
     * 缩放比
     */
    Double scale = 1.0;

    /**
     * appKey
     */
    String appKey;

    /**
     * 时间戳10位 new Date().getTime()/1000
     */
    Long timestamp;

    /**
     * 随机字符串 16位
     */
    String nonce;

    /**
     * 载荷
     */
    String payload;

    /**
     * 验签
     */
    String sign;

    /**
     * 是否返回base64格式
     */
    Boolean b64;


    /**
     * 返回Json字符串
     *
     * @return
     */
    public String toString() {
        return JsonUtils.toPrettyJson(this);
    }
}
