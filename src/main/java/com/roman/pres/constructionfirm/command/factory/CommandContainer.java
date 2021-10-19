package com.roman.pres.constructionfirm.command.factory;

import com.roman.pres.constructionfirm.command.ControllerCommandImpl;
import com.roman.pres.constructionfirm.exeption.ControllerCommandException;

import java.util.Map;

public class CommandContainer {
    private static Map<String, ControllerCommandImpl> commands;

    static {
        init();
    }

    private CommandContainer() {
    }

    private static void init() {
        //todo --> put all commands
        commands.put("interface name", null);
    }

    public static ControllerCommandImpl getCommand(String name) throws ControllerCommandException {
        if (commands.containsKey(name)){
            return commands.get(name);
        }
        throw new ControllerCommandException(String.format("Command %s not found", name));
    }
}
