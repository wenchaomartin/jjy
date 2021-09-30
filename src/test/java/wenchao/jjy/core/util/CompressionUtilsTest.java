package wenchao.jjy.core.util;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;

public class CompressionUtilsTest extends TestCase {

    public void testCompressAndDepress() throws IOException, DataFormatException {
        byte[] bytes = CompressionUtils.compress(("blob" + "\0" + "123").getBytes(StandardCharsets.UTF_8));
        byte[] originalByte = CompressionUtils.decompress(bytes);
        Assert.assertEquals(new String(originalByte), "blob"+"\0"+"123");
    }


}