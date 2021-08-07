package com.navi.loan.dao;

public class BalanceCommand implements Command {

    private String bankName;
    private String borrowerName;
    private Integer emiNo;

    public BalanceCommand(String bankName, String borrowerName, Integer emiNo) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiNo = emiNo;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Integer getEmiNo() {
        return emiNo;
    }

    public String getType(){
        return "BALANCE";
    }
}
