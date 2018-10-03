    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Order.OrderItem;
import java.util.Date;


/**
 *
 * @author Kiran
 */
public class MachineRequest extends WorkRequest{

    private int requestQuantity;
    private int requestId;
    private static int count=0;
    private double totalPrice;
    private double paidAmount;
    private double remainingAmount;
    private double installmentPrice;
    private int noOfInstallmentsRemaining;
    
    private String nextDateforLoanPanel;
    private String dateOfPurchaseInString;
    private String nextDateOfInstallmentInString;
    private String paymentDateInString;
    private Date dateOfPurchase;
    private Date nextInstallmentDate;
    private Date paymentDate;
     
    public MachineRequest(){
        count++;
        requestId=count;
    }

    public String getNextDateforLoanPanel() {
        return nextDateforLoanPanel;
    }

    public void setNextDateforLoanPanel(String nextDateforLoanPanel) {
        this.nextDateforLoanPanel = nextDateforLoanPanel;
    }
    
    public int getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public int getRequestId() {
        return requestId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public double getInstallmentPrice() {
        return installmentPrice;
    }

    public void setInstallmentPrice(double installmentPrice) {
        this.installmentPrice = installmentPrice;
    }

    public int getNoOfInstallmentsRemaining() {
        return noOfInstallmentsRemaining;
    }

    public void setNoOfInstallmentsRemaining(int noOfInstallmentsRemaining) {
        this.noOfInstallmentsRemaining = noOfInstallmentsRemaining;
    }

    public String getDateOfPurchaseInString() {
        return dateOfPurchaseInString;
    }

    public void setDateOfPurchaseInString(String dateOfPurchaseInString) {
        this.dateOfPurchaseInString = dateOfPurchaseInString;
    }

    public String getNextDateOfInstallmentInString() {
        return nextDateOfInstallmentInString;
    }

    public void setNextDateOfInstallmentInString(String nextDateOfInstallmentInString) {
        this.nextDateOfInstallmentInString = nextDateOfInstallmentInString;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getNextInstallmentDate() {
        return nextInstallmentDate;
    }

    public void setNextInstallmentDate(Date nextInstallmentDate) {
        this.nextInstallmentDate = nextInstallmentDate;
    }

    public String getPaymentDateInString() {
        return paymentDateInString;
    }

    public void setPaymentDateInString(String paymentDateInString) {
        this.paymentDateInString = paymentDateInString;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    
    
    @Override
    public String toString()
    {
        return String.valueOf(this.requestQuantity);
    }
}
