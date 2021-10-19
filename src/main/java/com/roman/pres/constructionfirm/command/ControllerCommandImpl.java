package com.roman.pres.constructionfirm.command;

import java.util.HashMap;
import java.util.Map;

public abstract class ControllerCommandImpl implements ControllerCommand, AbstractCommand {
    protected Map<String, Object> attributes = new HashMap<>();

    @Override
    public final void execute() {
        setRequestProperties();
        validate();
        performExecute();
        setResponseProperties();
    }

    @Override
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes.putAll(attributes);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
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
