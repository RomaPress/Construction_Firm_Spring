package com.roman.pres.constructionfirm.command;

import org.springframework.ui.Model;

import java.util.Map;

public abstract class ControllerCommandImpl implements ControllerCommand, AbstractCommand {
    private Model model;

    @Override
    public final void execute() {
        Map<String, Object> attr = getRequestParameters();
        validate();
        performExecute();
        setResponseParam(attr);
    }

    @Override
    public final void setModel(Model model) {
        this.model = model;
    }


    @Override
    public Map<String, Object> getRequestParameters() {
        return model.asMap();
    }

    @Override
    public void validate() {
    }

    @Override
    public void setResponseParam(Map<String, Object> attributes) {
        model.addAllAttributes(attributes);
    }
}
