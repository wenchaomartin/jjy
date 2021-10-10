package wenchao.jjy.core.cmd;

import java.io.File;

public class ADD implements CMD {
    private String path;

    public ADD(String path) {
        this.path = path;
    }

    @Override
    public void run() throws Exception {
        File file = new File(path);
        if (!file.exists()) throw new IllegalArgumentException(path + "not exists");

        if (file.isFile()) {
            //todo , jjy 只在根目录中有效
            // todo red index 文件内容

        } else {

        }
    }

}
