package wenchao.jjy.core;

import wenchao.jjy.core.cmd.ADD;
import wenchao.jjy.core.cmd.CMD;
import wenchao.jjy.core.cmd.Init;

public class CmdFactory {

    public static CMD create(String cmdName, String... argument) {
        if ("init".equals(cmdName)) {
            return new Init();
        } else if ("add".equals(cmdName)) {
            return new ADD(argument[0]);
        } else {
            throw new IllegalArgumentException("no this " + cmdName + " command");
        }
    }
}
