package com.navi.loan.dao;

public class PaymentCommand implements Command {

    private String bankName;
    private String borrowerName;
    private LumpSumPayment lumpSumPayment;

    public PaymentCommand(String bankName, String borrowerName, Integer lumpSumAmount, Integer emiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.lumpSumPayment = new LumpSumPayment(lumpSumAmount, emiNo);
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public LumpSumPayment getLumpSumPayment() {
        return lumpSumPayment;
    }

    public String getType() {
        return "PAYMENT";
    }
}
