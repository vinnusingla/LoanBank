package com.navi.loan.service.impl;

import com.navi.loan.dao.BalanceCommand;
import com.navi.loan.dao.Command;
import com.navi.loan.dao.LoanCommand;
import com.navi.loan.dao.PaymentCommand;
import com.navi.loan.service.InputHandler;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TxtFileInputHandler implements InputHandler {
    static Logger log = Logger.getLogger(TxtFileInputHandler.class.getName());

    private LoanCommand parseLoanCommand(List<String> split_command) {
        String bankName = split_command.get(1);
        String borrowerName = split_command.get(2);
        Double principal = Double.parseDouble(split_command.get(3));
        Integer years = Integer.parseInt(split_command.get(4));
        Double rateOfInterest = Double.parseDouble(split_command.get(5))/100;
        return new LoanCommand(bankName, borrowerName, principal, years, rateOfInterest);
    }

    private PaymentCommand parsePaymentCommand(List<String> split_command) {
        String bankName = split_command.get(1);
        String borrowerName = split_command.get(2);
        Integer lumpSumPayment = Integer.parseInt(split_command.get(3));
        Integer emiNo = Integer.parseInt(split_command.get(4));
        return new PaymentCommand(bankName, borrowerName, lumpSumPayment, emiNo);
    }

    private BalanceCommand parseBalanceCommand(List<String> split_command) {
        String bankName = split_command.get(1);
        String borrowerName = split_command.get(2);
        Integer emiNo = Integer.parseInt(split_command.get(3));
        return new BalanceCommand(bankName, borrowerName, emiNo);
    }

    private Command parseCommand(List<String> split_command) throws Exception {
        if (Objects.equals(split_command.get(0), "LOAN")) {
            return parseLoanCommand(split_command);
        } else if (Objects.equals(split_command.get(0), "PAYMENT")) {
            return parsePaymentCommand(split_command);
        } else if (Objects.equals(split_command.get(0), "BALANCE")) {
            return parseBalanceCommand(split_command);
        } else {
            throw new Exception("Unrecognized command");
        }
    }

    public List<Command> parseFile(String filePath) {
        List<Command> parsedCommands = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String command = br.readLine();
            while (command != null) {
                List<String> split_command = new ArrayList<String>(Arrays.asList(command.split(" ")));
                parsedCommands.add(parseCommand(split_command));
                command = br.readLine();
            }
        } catch (Exception e) {
            log.error("Error during parsing file", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("Error in closing the BufferedReader");
                }
            }
        }
        return parsedCommands;
    }
}
