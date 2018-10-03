/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Machine.Machine;
import java.util.Date;


/**
 *
 * @author Kiran
 */
public class OrderItem {
    
    private Machine machine;
    private static int count=0;
    private int orderItemId;
    private int orderItemQuantity;
    
    private String dOfPurchase;
    private String ndOfInstallment;
    private double salesPrice;
    private double moneypaidForRequested;
    private double remainingforOrder;
    private int installmentsRemain;
    
    
    public OrderItem() 
    {
        count++;
        orderItemId=count;
        machine = new Machine();
    }

    public int getInstallmentsRemain() {
        return installmentsRemain;
    }

    public void setInstallmentsRemain(int installmentsRemain) {
        this.installmentsRemain = installmentsRemain;
    }

    
    public double getMoneypaidForRequested() {
        return moneypaidForRequested;
    }

    public void setMoneypaidForRequested(double moneypaidForRequested) {
        this.moneypaidForRequested = moneypaidForRequested;
    }


    public double getRemainingforOrder() {
        return remainingforOrder;
    }

    public void setRemainingforOrder(double remainingforOrder) {
        this.remainingforOrder = remainingforOrder;
    }

    public String getdOfPurchase() {
        return dOfPurchase;
    }

    public void setdOfPurchase(String dOfPurchase) {
        this.dOfPurchase = dOfPurchase;
    }

    public String getNdOfInstallment() {
        return ndOfInstallment;
    }

    public void setNdOfInstallment(String ndOfInstallment) {
        this.ndOfInstallment = ndOfInstallment;
    }

    
    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public int getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(int orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }
    
    @Override
    public String toString()
    {
        return machine.getName();
    }
}
