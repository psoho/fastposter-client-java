package cn.fastposter.cloud.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 海报类型
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.cn/"></>
 */
@Getter
@AllArgsConstructor
public enum PosterType {

    png("png"),
    jpeg("jpeg"),
    webp("webp"),
    pdf("pdf");

    final String value;
}
