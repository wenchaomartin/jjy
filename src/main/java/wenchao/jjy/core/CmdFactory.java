package wenchao.jjy.core;

import wenchao.jjy.core.cmd.CMD;
import wenchao.jjy.core.cmd.Init;

public class CmdFactory {

    public static CMD create(String cmdName) {
        if ("init".equals(cmdName)) {
            return new Init();
        } else {
            throw new IllegalArgumentException("no this " + cmdName + " command");
        }
    }
}
