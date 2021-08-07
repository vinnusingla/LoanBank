package com.navi.loan.service;

import com.navi.loan.dao.Command;

public interface LoanDbService {
    public void processCommand(Command command);
}
