package com.roman.pres.constructionfirm.controller.commands;

import com.roman.pres.constructionfirm.command.ControllerCommand;
import com.roman.pres.constructionfirm.services.MaterialService;

public interface GetMaterialObjectCmd extends ControllerCommand {
    String NAME = GetMaterialObjectCmd.class.getName();

    void setMaterialService(MaterialService materialService);
}
