package wenchao.jjy.core.object;

import com.google.common.hash.Hashing;
import wenchao.jjy.core.util.ByteUtils;

import java.nio.charset.StandardCharsets;

public class GitHashUtil {

    private GitHashUtil() {
    }

    /**
     * 生成blob对象的hash
     *
     * @param content
     * @return
     */
    public static String gitBlobObjectHash(byte[] content) {
        String header = "blob" + " " + content.length + "\0";
        String hash = Hashing.sha256()
                .hashBytes(ByteUtils.twoByteArrayAdd(header.getBytes(StandardCharsets.UTF_8), content))
                .toString();
        return hash;
    }

}
