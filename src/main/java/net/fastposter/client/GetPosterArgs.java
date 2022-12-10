package net.fastposter.client;

import lombok.Builder;
import lombok.Data;

/**
 * 获取海报参数
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
     * appKey
     */
    String appKey;

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
