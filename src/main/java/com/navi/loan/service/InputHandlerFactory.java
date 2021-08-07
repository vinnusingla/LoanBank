package com.navi.loan.service;

import com.navi.loan.service.impl.TxtFileInputHandler;

import java.util.Objects;

public class InputHandlerFactory {
    public InputHandler getHandler(String handlerType) throws Exception {
        if (Objects.equals(handlerType, "txtFileHandler")) {
            return new TxtFileInputHandler();
        } else {
            throw new Exception("Unknown Handler");
        }
    }
}
