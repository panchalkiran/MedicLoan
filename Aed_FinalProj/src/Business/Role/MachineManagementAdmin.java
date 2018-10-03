/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.MachineManagementAdmin.MachineManagementAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Kiran
 */
public class MachineManagementAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new MachineManagementAdminWorkAreaJPanel(userProcessContainer,enterprise);
    }
    @Override
    public String toString()
    {
        return RoleType.MachineManagementAdmin.getValue();
    }
}
