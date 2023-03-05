package net.fastposter.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 海报类型
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://cloud.fastposter.net/doc/sdk/java.html"></>
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
