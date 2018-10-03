/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Kiran
 */
public abstract class Enterprise extends Organization{
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private WorkQueue entWorkQueue; 
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
        entWorkQueue= new WorkQueue();
    }
    
    public enum EnterpriseType{
        Hospital("Hospital Enterprise"),
        MachineManagement("Machine Enterprise"), 
        Supplier("Supplier Enterprise"),
        UniversityHealthCare("UniversityHealthCare Enterprise"),
        NGO("NGO Enterprise");
        
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public WorkQueue getEntWorkQueue() {
        return entWorkQueue;
    }

    public void setEntWorkQueue(WorkQueue entWorkQueue) {
        this.entWorkQueue = entWorkQueue;
    }
    
    
}
