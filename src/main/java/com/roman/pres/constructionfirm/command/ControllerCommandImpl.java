package com.roman.pres.constructionfirm.command;

import org.springframework.ui.Model;

public abstract class ControllerCommandImpl implements ControllerCommand, AbstractCommand {
    protected Model attributes;

    @Override
    public final void execute() {
        setRequestProperties();
        validate();
        performExecute();
        setResponseProperties();
    }

    @Override
    public void setModel(Model attributes) {
        this.attributes = attributes;
    }

    @Override
    public void setRequestProperties() {
    }

    @Override
    public void validate() {
    }

    @Override
    public void setResponseProperties() {
    }
}
