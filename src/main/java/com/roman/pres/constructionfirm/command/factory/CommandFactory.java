package com.roman.pres.constructionfirm.command.factory;

import com.roman.pres.constructionfirm.command.ControllerCommandImpl;
import com.roman.pres.constructionfirm.exeption.ControllerCommandException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandFactory {
    private static final String CLASSNAME = CommandFactory.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASSNAME);

    private CommandFactory() {
    }

    public static ControllerCommandImpl createInstance(String name) throws ControllerCommandException {
        try {
            return CommandContainer.getCommand(name);
        } catch (ControllerCommandException e) {
            LOGGER.log(Level.SEVERE, "The problem has occurred while creating instance of {0} class", name);
            throw new ControllerCommandException(e.getMessage());
        }
    }
}

