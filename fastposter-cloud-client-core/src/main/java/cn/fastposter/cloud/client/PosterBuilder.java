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
    protected Map<String, Object> params = new HashMap<>();

    FastposterCloudClient client;

    /**
     * 增加参数，支持链式调用
     *
     * @param name
     * @param value
     * @return
     */
    public PosterBuilder add(String name, Object value) {
        params.put(name, value);
        return this;
    }

    /**
     * 构建海报，发起HTTP请求
     *
     * @return
     */
    public Poster build() {
        return client.build(this);
    }

    /**
     * 设置海报参数
     *
     * @param params 参数
     * @return
     */
    public PosterBuilder params(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    /**
     * 海报图片以BASE64编码形式返回
     *
     * @return
     */
    public PosterBuilder b64() {
        this.b64 = true;
        return this;
    }

    /**
     * 设置海报类型，通过枚举
     *
     * @param posterType
     * @return
     */
    private PosterBuilder type(PosterType posterType) {
        assert posterType != null;
        this.type = posterType;
        return this;
    }

    /**
     * 设置海报类型
     *
     * @param type jpg|jpeg|png|webp|pdf
     * @return
     */
    public PosterBuilder type(String type) {
        assert type != null;
        this.type = Enum.valueOf(PosterType.class, type.trim().toLowerCase());
        return this;
    }

    /**
     * 设置海报类型为png
     *
     * @return
     */
    public PosterBuilder png() {
        this.type = PosterType.png;
        return this;
    }

    /**
     * 设置海报类型为jpg
     *
     * @return
     */
    public PosterBuilder jpg() {
        this.type = PosterType.jpg;
        return this;
    }

    /**
     * 设置海报类型为jpeg
     *
     * @return
     */
    public PosterBuilder jpeg() {
        this.type = PosterType.jpeg;
        return this;
    }

    /**
     * 设置海报类型为pdf
     *
     * @return
     */
    public PosterBuilder pdf() {
        this.type = PosterType.pdf;
        return this;
    }

    /**
     * 设置海报类型为webp
     *
     * @return
     */
    public PosterBuilder webp() {
        this.type = PosterType.webp;
        return this;
    }

    /**
     * 设置海报缩放比
     *
     * @param scale 0.1 ~ 1.0
     * @return
     */
    public PosterBuilder scale(double scale) {
        this.scale = scale;
        return this;
    }

}
