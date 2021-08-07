package com.navi.loan.dao;

public class LumpSumPayment {
    private Integer lumpSumAmount;
    private Integer emiNo;

    public LumpSumPayment(Integer lumpSumAmount, Integer emiNo) {
        this.lumpSumAmount = lumpSumAmount;
        this.emiNo = emiNo;
    }

    public Integer getLumpSumAmount() {
        return lumpSumAmount;
    }

    public Integer getEmiNo() {
        return emiNo;
    }
}
