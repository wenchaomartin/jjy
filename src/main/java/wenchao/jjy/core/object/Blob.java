package wenchao.jjy.core.object;

import com.google.common.hash.Hashing;
import org.apache.commons.io.FileUtils;
import wenchao.jjy.core.util.ByteUtils;
import wenchao.jjy.core.util.CompressionUtils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

public class Blob implements GitObject, Serializable {
    private static final String FORMAT = "blob";

    private final String header;

    private final byte[] content;

    private final String serializableDirectory;

    private final String hash;

    private final String localName;

    private byte[] fullData;

    private byte[] compressByte;

    public Blob(byte[] content) {
        this.content = content;
        this.header = FORMAT + " " + content.length + "\0";
        this.hash = Hashing.sha256()
                .hashBytes(ByteUtils.twoByteArrayAdd(header.getBytes(StandardCharsets.UTF_8), content))
                .toString();
        serializableDirectory = ".git/" + "objects/" + hash.substring(0, 2);
        localName = hash.substring(2);
        try {
            fullData = ByteUtils.twoByteArrayAdd(header.getBytes(StandardCharsets.UTF_8), content);
            compressByte = CompressionUtils.compress(fullData);
            FileUtils.writeByteArrayToFile(new File(serializableDirectory + "/" + localName), compressByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFORMAT() {
        return FORMAT;
    }

    public String getHeader() {
        return header;
    }

    public byte[] getContent() {
        return content;
    }

    public String path() {
        return serializableDirectory + "/" + localName;
    }

    public String getHash() {
        return hash;
    }

    public byte[] getFullData() {
        return fullData;
    }

    public byte[] getCompressByte() {
        return compressByte;
    }


}
