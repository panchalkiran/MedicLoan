/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Machine.MachineCatalog;
import Business.Organization.Organization;
import Business.Organization.SupplierOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.SupplierRole.SupplierWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Kiran
 */
public class Supplier extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new SupplierWorkAreaJPanel(userProcessContainer,  account,organization,business);
    }
    
    @Override
    public String toString()
    {
        return RoleType.Supplier.getValue();
    }
    
}
