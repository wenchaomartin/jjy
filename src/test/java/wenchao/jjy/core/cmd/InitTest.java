package wenchao.jjy.core.cmd;


import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class InitTest {
    @Test
    public void testInit() throws IOException {

        Init initCmd = new Init();
        try {
            initCmd.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        File objects = new File("./.git/objects");
        Assert.assertTrue(objects.delete());

        File head = new File("./.git/HEAD");
        Assert.assertTrue(head.delete());

        File ref = new File("./.git/ref");
        Assert.assertTrue(ref.delete());

        File init = new File("./.git");
        Assert.assertTrue(init.delete());
    }
}