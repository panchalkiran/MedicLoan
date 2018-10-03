/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Loan;

/**
 *
 * @author Kiran
 */
public class Loan {
    
    private static int count=0;
    private int loanId;
    private int timePeriod;
    private int numberOfInstallment;
    private double installmentsPaidPrice;
    private double totalOrderItemAmount;
    ////////////////////////////////////
    private int remainingInstallment = numberOfInstallment-1;
    private double remainingAmountTobePaid;
    private String dateOfPurchase;
    private String nextDateOfInstallment;

    public Loan()
    {
        count++;
        loanId=count;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getNextDateOfInstallment() {
        return nextDateOfInstallment;
    }

    public void setNextDateOfInstallment(String nextDateOfInstallment) {
        this.nextDateOfInstallment = nextDateOfInstallment;
    }

    
     public double getTotalOrderItemAmount() {
        return totalOrderItemAmount;
    }

    public void setTotalOrderItemAmount(double totalOrderItemAmount) {
        this.totalOrderItemAmount = totalOrderItemAmount;
    }

    public int getRemainingInstallment() {
        return remainingInstallment;
    }

    public void setRemainingInstallment(int remainingInstallment) {
        this.remainingInstallment = remainingInstallment;
    }
    
    public double getRemainingAmountTobePaid() {
        return remainingAmountTobePaid;
    }

    public void setRemainingAmountTobePaid(double remainingAmountTobePaid) {
        this.remainingAmountTobePaid = remainingAmountTobePaid;
    }

    public double getInstallmentsPaidPrice() {
        return installmentsPaidPrice;
    }

    public void setInstallmentsPaidPrice(double installmentsPaidPrice) {
        this.installmentsPaidPrice = installmentsPaidPrice;
    }
    
   
    public int getLoanId() {
        return loanId;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public int getNumberOfInstallment() {
        return numberOfInstallment;
    }

    public void setNumberOfInstallment(int numberOfInstallment) {
        this.numberOfInstallment = numberOfInstallment;
    }
    
    
}
