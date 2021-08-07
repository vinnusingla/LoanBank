package com.navi.loan.service;

import com.navi.loan.dao.Command;

import java.util.List;

public interface InputHandler {
    public List<Command> parseFile(String filePath);
}
