package com.navi.loan.dao;

import java.util.Objects;

public class LoanUser {
    private String bankName;
    private String borrowerName;

    public LoanUser(String bankName, String borrowerName) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanUser loanUser = (LoanUser) o;
        return bankName.equals(loanUser.bankName) && borrowerName.equals(loanUser.borrowerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, borrowerName);
    }

}
