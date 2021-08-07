package com.navi.loan.service.impl;

import com.navi.loan.dao.*;
import com.navi.loan.service.LoanDbService;

import java.util.HashMap;
import java.util.Objects;

public class LoanDbServiceImpl implements LoanDbService {
    // Assuming user can't have multiple loans in same bank as we can't differentiate b/w those loans with given info
    HashMap<LoanUser, Loan> loanDb;

    public LoanDbServiceImpl() {
        loanDb = new HashMap<>();
    }

    public void processCommand(Command command) {
        if (Objects.equals(command.getType(), "LOAN")) {
            LoanCommand loanCommand = (LoanCommand) command;
            processLoanCommand(loanCommand);
        } else if (Objects.equals(command.getType(), "PAYMENT")) {
            PaymentCommand paymentCommand = (PaymentCommand) command;
            processPaymentCommand(paymentCommand);
        } else if (Objects.equals(command.getType(), "BALANCE")) {
            BalanceCommand balanceCommand = (BalanceCommand) command;
            processBalanceCommand(balanceCommand);
        }
    }

    private void processLoanCommand(LoanCommand loanCommand) {
        Loan loan = new Loan(
                loanCommand.getBankName(),
                loanCommand.getBorrowerName(),
                loanCommand.getPrincipal(),
                loanCommand.getYears(),
                loanCommand.getRateOfInterest()
        );
        LoanUser loanUser = new LoanUser(loanCommand.getBankName(), loanCommand.getBorrowerName());
        this.loanDb.put(loanUser, loan);
    }

    private void processPaymentCommand(PaymentCommand paymentCommand) {
        LoanUser loanUser = new LoanUser(paymentCommand.getBankName(), paymentCommand.getBorrowerName());
        Loan loan = this.loanDb.get(loanUser);
        loan.addLumpSumPayment(paymentCommand.getLumpSumPayment());
    }

    private void processBalanceCommand(BalanceCommand balanceCommand) {
        LoanUser loanUser = new LoanUser(balanceCommand.getBankName(), balanceCommand.getBorrowerName());
        Loan loan = this.loanDb.get(loanUser);
        BalanceCommandOutput ans = loan.getBalance(balanceCommand.getEmiNo());
        System.out.println(ans);
    }
}
