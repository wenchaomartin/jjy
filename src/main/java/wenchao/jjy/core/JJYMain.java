package wenchao.jjy.core;

import wenchao.jjy.core.cmd.CMD;

public class JJYMain {
    public static void main(String[] args) throws Exception {
        CMD cmd = CmdFactory.create(args[0]);
        cmd.run();
    }

}
