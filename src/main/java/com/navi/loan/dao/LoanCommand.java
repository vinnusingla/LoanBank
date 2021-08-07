package com.navi.loan.dao;

public class LoanCommand implements Command {

    private String bankName;
    private String borrowerName;
    private Double principal;
    private Integer years;
    private Double rateOfInterest;

    public LoanCommand(String bankName, String borrowerName, Double principal, Integer years, Double rateOfInterest) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.years = years;
        this.rateOfInterest = rateOfInterest;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Double getPrincipal() {
        return principal;
    }

    public Integer getYears() {
        return years;
    }

    public Double getRateOfInterest() {
        return rateOfInterest;
    }

    public String getType(){
        return "LOAN";
    }
}
