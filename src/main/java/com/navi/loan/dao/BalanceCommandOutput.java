package com.navi.loan.dao;

public class BalanceCommandOutput {

    private String bankName;
    private String borrowerName;
    private Integer emiLeft;
    private Integer amountPaid;

    public BalanceCommandOutput(String bankName, String borrowerName, Integer emiLeft, Integer amountPaid) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiLeft = emiLeft;
        this.amountPaid = amountPaid;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Integer getEmiLeft() {
        return emiLeft;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return bankName + " " + borrowerName + " " + amountPaid + " " + emiLeft;
    }
}
