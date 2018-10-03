/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Machine.MachineCatalog;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Kiran
 */
public class Supplier {
    private String supplierName;
    private static int sCount;
    private String supplierId;
    private MachineCatalog machineList;
    private WorkQueue workQueue;
    
    public Supplier(){
        supplierId= "SID"+(++sCount);
        machineList= new MachineCatalog();
        workQueue= new WorkQueue();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public MachineCatalog getMachineList() {
        return machineList;
    }

    public void setMachineList(MachineCatalog machineList) {
        this.machineList = machineList;
    }
    
    @Override
    public String toString(){
        return supplierName;
    }
    
    
}
