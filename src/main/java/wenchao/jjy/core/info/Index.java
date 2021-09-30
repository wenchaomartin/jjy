package wenchao.jjy.core.info;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import wenchao.jjy.core.object.Blob;
import wenchao.jjy.core.object.GitHashUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Index {

    private static final String DIRC = "DIRC";
    private static final Integer version = 2;
    private static final Integer entryNumbers = 0;

    private static final String indexPath = ".git/index";

    private List<Entry> entryList = new ArrayList<>();


    public Index() {
        File indexFile = new File(indexPath);
    }

    public void add(File file) throws IOException {
        if (file.isDirectory()) {

        } else {
            byte[] bytes = FileUtils.readFileToByteArray(file);
            String hashStr = GitHashUtil.gitBlobObjectHash(bytes);
            //TODO 可能bug , path  相对和绝对之分
            boolean exists = existsEntry(file.getAbsolutePath(), hashStr);
            if (!exists) {
                Blob blob = new Blob(bytes);
                Entry entry = Entry.builder()
                        .hash(hashStr)
                        .path(file.getAbsolutePath())
                        .build();
                entryList.add(entry);
            }
        }
    }

    private boolean existsEntry(String path, String hash) {
        if (CollectionUtils.isEmpty(entryList)) {
            return false;
        } else {
            for (Entry entry : entryList) {
                if (entry.getPath().equals(path) && entry.getHash().equals(hash)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void updateIndex() {
        String header = DIRC + " " + version + " " + entryList.size();
        byte[] headerByte = header.getBytes(StandardCharsets.UTF_8);
        byte[] entryListByte = convert(entryList);


    }

    public byte[] convert(List list) {
        byte[] bytes = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(list);
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

}
