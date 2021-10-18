package com.roman.pres.constructionfirm.command;

import java.util.Map;

public abstract class ControllerCommandImpl implements ControllerCommand, TemplateCommand {

    @Override
    public final void execute() {
        //todo --> need to adapt to spring controller
        getRequestParameters();
        validate();
        performExecute();
        setResponseParam(null);
    }

    @Override
    public Map<String, Object> getRequestParameters() {
        return null;
    }

    @Override
    public void validate() {

    }

    @Override
    public void setResponseParam(Map<String, Object> attributes) {
    }
}
