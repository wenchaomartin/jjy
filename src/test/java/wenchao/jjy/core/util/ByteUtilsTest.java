package wenchao.jjy.core.util;

import junit.framework.TestCase;
import org.junit.Assert;

import java.nio.charset.StandardCharsets;

public class ByteUtilsTest extends TestCase {

    public void testTwoByteArrayAdd() {
        byte[] first = "1".getBytes(StandardCharsets.UTF_8);
        byte[] second = "2".getBytes(StandardCharsets.UTF_8);
        byte[] result = ByteUtils.twoByteArrayAdd(first, second);
        Assert.assertEquals(new String(result), "12");

    }
}