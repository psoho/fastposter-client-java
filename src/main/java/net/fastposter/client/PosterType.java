package net.fastposter.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PosterType {

    png("png"),
    jpeg("jpeg"),
    webp("webp"),
    pdf("pdf");

    final String value;
}
