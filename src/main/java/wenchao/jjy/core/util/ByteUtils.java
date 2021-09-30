package wenchao.jjy.core.util;

public class ByteUtils {

    private ByteUtils() {
    }

    public static byte[] twoByteArrayAdd(byte[] first, byte[] second) {

        byte[] destination = new byte[first.length + second.length];
        System.arraycopy(first, 0, destination, 0, first.length);
        System.arraycopy(second, 0, destination, first.length, second.length);
        return destination;
    }
}
