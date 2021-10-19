package com.roman.pres.constructionfirm.command;

public interface AbstractCommand {
    void setRequestProperties();

    void validate();

    void performExecute();

    void setResponseProperties();
}
