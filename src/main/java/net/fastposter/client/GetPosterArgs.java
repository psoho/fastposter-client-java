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

}
