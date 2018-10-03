/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Machine;

import Business.Loan.Loan;
import java.util.Date;

/**
 *
 * @author Kiran
 */
public class Machine {
    
    private String code;
    private static int count=100;
    private String name;
    private String type;
    private int quantity;
    private int price;
    private double interestRate;
    private Date dateOfPurchase;
    private Date dateOfEntry;
    private String dateOfPurchaseInString;
    private String dateOfEntryInString;
    private String nextInstallmentDate;
    private Loan loan;
    private boolean flag;
    private boolean recommend;
  
    public enum MachineType
    {
        Anesthetic("Anesthetic"),
        Emergency("Emergency"),
        Dressings("Dressings"),
        Dental("Dental"),
        Ophthalmic("Ophthalmic"),
        Orthopedic("Orthopedic"),
        Veterinary("Veterinary"),
        MedicalTesting("MedicalTesting"),
        SmallMachines("SmallMachines"),
        Surgical("Surgical");
        
        private String value;
        private MachineType(String value)
        {
            this.value=value;
        }

        public String getValue() {
            return value;
        }
    }

    
    public Machine()
    {
        code="M"+count;
        count++;
        loan = new Loan();
    }

    public String getNextInstallmentDate() {
        return nextInstallmentDate;
    }

    public void setNextInstallmentDate(String nextInstallmentDate) {
        this.nextInstallmentDate = nextInstallmentDate;
    }

    
    public String getDateOfPurchaseInString() {
        return dateOfPurchaseInString;
    }

    public void setDateOfPurchaseInString(String dateOfPurchaseInString) {
        this.dateOfPurchaseInString = dateOfPurchaseInString;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getDateOfEntryInString() {
        return dateOfEntryInString;
    }

    public void setDateOfEntryInString(String dateOfEntryInString) {
        this.dateOfEntryInString = dateOfEntryInString;
    }
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }


    
    @Override
    public String toString()
    {
        return name;
    }
    
}
