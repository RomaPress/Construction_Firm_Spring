package com.roman.pres.constructionfirm.command;

import java.util.Map;

public interface ControllerCommand {
    void execute();

    void setAttributes(Map<String, Object> attributes);

    Map<String, Object> getAttributes();
}
