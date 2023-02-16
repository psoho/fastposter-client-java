package net.fastposter.client;

/**
 * 可构建的对象
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://cloud.fastposter.net/doc/"></>
 */
public interface Buildable {

    Poster build(PosterBuilder posterBuilder);

    GetPosterArgs getArgs(PosterBuilder posterBuilder);

}
