package com.navi.loan.dao;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    private String bankName;
    private String borrowerName;
    private Double principal;
    private Integer years;
    private Double rateOfInterest;
    private Integer emi;
    private List<LumpSumPayment> lumpSumPayments;

    public Loan(String bankName, String borrowerName, Double principal, Integer years, Double rateOfInterest) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.years = years;
        this.rateOfInterest = rateOfInterest;
        this.emi = calculateEmi();
        this.lumpSumPayments = new ArrayList<>();
    }

    public Double getInterest() {
        return this.principal * this.years * this.rateOfInterest;
    }

    public Double getTotalLoanAmount() {
        return this.principal + getInterest();
    }

    public void addLumpSumPayment(LumpSumPayment lumpSumPayment) {
        this.lumpSumPayments.add(lumpSumPayment);
    }

    private Integer calculateEmi() {
        return (int) Math.ceil(getTotalLoanAmount() / (12 * this.years));
    }

    // return's balance after n th emi
    public BalanceCommandOutput getBalance(int n) {
        Integer lumpSumAmountPaid = 0;
        Integer lumpSumEmiNumber;
        Integer lumpSumAmount;

        // calculate lump sum amount paid till the query emi
        for (LumpSumPayment lumpSumPayment : this.lumpSumPayments) {
            lumpSumEmiNumber = lumpSumPayment.getEmiNo();
            lumpSumAmount = lumpSumPayment.getLumpSumAmount();
            if (lumpSumEmiNumber <= n) {
                lumpSumAmountPaid = lumpSumAmountPaid + lumpSumAmount;
            }
        }

        // calculate remaining amount
        Integer amountPaid = lumpSumAmountPaid + n * this.emi;
        double remainingAmount = getTotalLoanAmount() - amountPaid;
        if (remainingAmount < 0) remainingAmount = 0.0;

        // calculate remaining emi
        Integer remainingEmi = (int) Math.ceil(remainingAmount / this.emi);

        return new BalanceCommandOutput(bankName, borrowerName, remainingEmi, amountPaid);
    }
}
