/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.Supplier;
import Business.Supplier.SupplierDirectory;
import java.util.HashSet;

/**
 *
 * @author Kiran
 */
public class SupplierOrganization extends Organization{

    private SupplierDirectory supplierList;
    public SupplierOrganization() 
    {
        super(Organization.Type.Supplier.getValue());
        supplierList= new SupplierDirectory();
        
    }

    public SupplierDirectory getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(SupplierDirectory supplierList) {
        this.supplierList = supplierList;
    }

    
    
    @Override
    public HashSet<Role> getSupportedRole() {
        roles= new HashSet<>();
        roles.add(new Supplier());
        return roles;
    }
    
    
}
