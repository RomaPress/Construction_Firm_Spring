package com.roman.pres.constructionfirm.command;

import org.springframework.ui.Model;

public interface ControllerCommand {
    void execute();

    void setModel(Model attributes);
}
