/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Kiran
 */
public class Network {
    
    private String name;
    private int id;
    private static int count=0;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network()
    {
        count++;
        id=count;
        enterpriseDirectory= new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public int getId() {
        return id;
    }
    

    @Override
    public String toString()
    {
        return name;
    }
    
}
