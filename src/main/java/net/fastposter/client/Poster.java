package net.fastposter.client;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

public class Poster extends FilterInputStream {
    public Poster(String name, InputStream body) {
        super(body);
    }

    @SneakyThrows
    public void save(String name) {
        IOUtils.copy(this, new FileOutputStream(name));
    }

}
