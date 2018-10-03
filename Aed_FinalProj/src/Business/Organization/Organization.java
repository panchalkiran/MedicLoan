/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.HashSet;

/**
 *
 * @author Kiran
 */
public abstract class Organization {
    
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=1;
    public HashSet<Role> roles;
    
    public enum Type{
        Hospital("Hospital Organization"),
        Machine("Machine Organization"), 
        Supplier("Supplier Organization"),
        ResearchAndDevelopment("ResearchAndDevelopment Organization"), 
        UniversityHealthCare("University Health Care Organization"),
        NGO("NGO Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        roles = new HashSet<>();
        ++counter;
    }
    
    public abstract HashSet<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    @Override
    public String toString()
    {
        return name;
    }   
}
