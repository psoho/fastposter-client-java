package cn.fastposter.cloud.client;

import lombok.Builder;
import lombok.Data;

/**
 * 生成海报参数
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.net/"></>
 */
@Data
@Builder
public class GetPosterArgs {

    /**
     * 海报ID
     */
    Integer id;

    /**
     * 海报类型
     */
    String type;

    /**
     * 缩放比
     */
    double scale = 1.0;

    /**
     * appKey
     */
    String appKey;

    /**
     * 时间戳10位 new Date().getTime()/1000
     */
    Long timestamp;

    /**
     * 随机字符串已存在 16位
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


}
