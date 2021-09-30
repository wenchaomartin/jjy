package wenchao.jjy.core.object;

import org.junit.Assert;
import org.junit.Test;
import wenchao.jjy.core.util.CompressionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.zip.DataFormatException;

public class BlobTest {
    @Test
    public void createBlobConstructor() throws IOException, DataFormatException {
        String content = "123";
        Blob blob = new Blob(content.getBytes(StandardCharsets.UTF_8));
        File f = new File(blob.path());

        byte[] todoDepress = Files.readAllBytes(f.toPath());
        byte[] result = CompressionUtils.decompress(todoDepress);

        String str = new String(result, StandardCharsets.UTF_8);

        Assert.assertTrue(f.exists());
        Assert.assertTrue(Arrays.equals(todoDepress, blob.getCompressByte()));
        Assert.assertTrue(Arrays.equals(result, blob.getFullData()));


        Assert.assertEquals(content, str.substring(str.indexOf("\0") + 1));
        f.delete();
    }
}