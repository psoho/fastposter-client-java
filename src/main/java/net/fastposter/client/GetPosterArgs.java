package net.fastposter.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPosterArgs {

    Integer id;

    String appKey;

    String payload;

    String sign;

}
