package cn.fastposter.cloud.client;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class PosterBuilder {

    /**
     * 海报UUID
     */
    String uuid;

    /**
     * 海报类型
     */
    PosterType type;

    /**
     * 缩放比
     */
    Double scale = 1.0;

    /**
     * 是否返回base64格式
     */
    Boolean b64;

    @Builder.Default
    Map<String, Object> _params = new HashMap<>();

    FastposterCloudClient client;

    public PosterBuilder add(String name, Object value) {
        _params.put(name, value);
        return this;
    }

    public Poster build() {
        return client.build(this);
    }

    public PosterBuilder setParams(Map<String, Object> params) {
        this._params = params;
        return this;
    }

    public PosterBuilder b64() {
        this.b64 = true;
        return this;
    }

    public PosterBuilder type(PosterType posterType) {
        assert posterType != null;
        this.type = posterType;
        return this;
    }

    public PosterBuilder type(String posterType) {
        assert posterType != null;
        this.type = Enum.valueOf(PosterType.class, posterType.trim().toLowerCase());
        return this;
    }

    public PosterBuilder png() {
        this.type = PosterType.png;
        return this;
    }

    public PosterBuilder jpg() {
        this.type = PosterType.jpg;
        return this;
    }

    public PosterBuilder jpeg() {
        this.type = PosterType.jpeg;
        return this;
    }

    public PosterBuilder pdf() {
        this.type = PosterType.pdf;
        return this;
    }

    public PosterBuilder webp() {
        this.type = PosterType.webp;
        return this;
    }

}
