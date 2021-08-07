package com.navi.loan.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoanTest {

    private Loan getSampleLoan() {
        Loan loan = new Loan(
                "ICICQ",
                "Thor",
                10000.0,
                5,
                .06
        );
        return loan;
    }

    @Test
    public void testGetInterest() {
        Assert.assertEquals(new Double(3000.0), getSampleLoan().getInterest());
    }

    @Test
    public void testGetTotalLoanAmount() {
        Assert.assertEquals(new Double(13000.0), getSampleLoan().getTotalLoanAmount());
    }

    @Test
    public void testGetBalance() {
        Loan loan = getSampleLoan();
        Assert.assertEquals(new Integer(55), loan.getBalance(5).getEmiLeft());
        Assert.assertEquals(new Integer(1085), loan.getBalance(5).getAmountPaid());
    }

}
