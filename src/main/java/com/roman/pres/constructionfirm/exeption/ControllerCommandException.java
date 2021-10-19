package com.roman.pres.constructionfirm.exeption;

public class ControllerCommandException extends ReflectiveOperationException {
    public ControllerCommandException(String message){
        super(message);
    }
}
