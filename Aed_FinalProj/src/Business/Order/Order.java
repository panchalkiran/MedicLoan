/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Supplier.Supplier;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Kiran
 */
public class Order {
    
    private ArrayList<OrderItem> orderItemList;
    private Supplier supplier;
    private int orderNumber;
    private static int count=0;
    private int commission;
    private int totalRevenue;
    private UserAccount ua;
    
    public Order()
    {
        orderItemList= new ArrayList<OrderItem>();
        supplier = new Supplier();
        count++;
        orderNumber=count;
        ua=new UserAccount();
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public UserAccount getUa() {
        return ua;
    }

    public void setUa(UserAccount ua) {
        this.ua = ua;
    }
    
    public OrderItem addOrderItem()
    {
        OrderItem o = new OrderItem();
        orderItemList.add(o);
        return o;
    }
    
    public void removeOrderItem(OrderItem o)
    {
        orderItemList.remove(o);
    }
}
