package wenchao.jjy.core.cmd;

import java.io.File;

public class Init implements CMD {

    public void run() throws Exception {
        File currentDirectory = new File("./.git");
        currentDirectory.mkdir();
        File objectsFile = new File("./.git/objects");
        objectsFile.mkdir();
        File headFile = new File("./.git/HEAD");
        headFile.mkdir();
        File refFile = new File("./.git/ref");
        refFile.mkdir();
    }
}
