package com.navi.loan;

import com.navi.loan.dao.*;
import com.navi.loan.service.InputHandler;
import com.navi.loan.service.InputHandlerFactory;
import com.navi.loan.service.LoanDbService;
import com.navi.loan.service.impl.LoanDbServiceImpl;
import org.apache.log4j.Logger;

import java.util.*;

public class Geektrust {
    static Logger log = Logger.getLogger(Geektrust.class.getName());

    public static void main(String[] args) {
        String filePath = args[0];
//        String filePath = "E:\\Projects\\navibank\\sampleInput.txt";
        LoanDbService loanDbService = new LoanDbServiceImpl();
        InputHandlerFactory inputHandlerFactory = new InputHandlerFactory();
        try {
            InputHandler inputHandler = inputHandlerFactory.getHandler("txtFileHandler");
            List<Command> commands = inputHandler.parseFile(filePath);
            for (Command command : commands) {
                loanDbService.processCommand(command);
            }
        } catch (Exception e) {
            log.error("Program Failed due to exception", e);
        }
    }
}