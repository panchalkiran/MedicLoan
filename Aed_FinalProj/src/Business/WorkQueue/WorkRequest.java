/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Machine.Machine;
import Business.Order.OrderItem;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Kiran
 */
public abstract class WorkRequest {
    
    //private OrderItem orderItem;
    private Machine machine;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private String dayOfDelivery;
    private Date requestDate;
    private Date resolveDate;
   
    public WorkRequest(){
        requestDate = new Date();
    }

//    public OrderItem getOrderItem() {
//        return orderItem;
//    }
//
//    public void setOrderItem(OrderItem orderItem) {
//        this.orderItem = orderItem;
//    }

    
    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getDayOfDelivery() {
        return dayOfDelivery;
    }

    public void setDayOfDelivery(String dayOfDelivery) {
        this.dayOfDelivery = dayOfDelivery;
    }
    
    @Override
    public String toString(){
        return status;
    }
    
}
