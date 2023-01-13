package net.fastposter.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 海报类型
 *
 * @author Alex小新 fastposter@163.com
 * @site <a href="https://cloud.fastposter.net/"></>
 */
@Getter
@AllArgsConstructor
public enum PosterType {

    png("png"),
    jpeg("jpeg"),
    jpg("jpeg"),
    webp("webp"),
    pdf("pdf");

    final String value;
}
