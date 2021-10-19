package com.roman.pres.constructionfirm.command;

import java.util.Map;

public interface AbstractCommand {
    Map<String, Object> getRequestParameters();

    void validate();

    void performExecute();

    void setResponseParam(Map<String, Object> attributes);
}
