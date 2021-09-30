package wenchao.jjy.core.object;

import wenchao.jjy.core.util.CompressionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.DataFormatException;

public class GitObjectFactoryImpl implements GitObjectFactory {
    @Override
    public GitObject read(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("path not exists");
        }
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            CompressionUtils.decompress(bytes);

        } catch (IOException | DataFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void write(GitObject gitObject) {

    }
}
