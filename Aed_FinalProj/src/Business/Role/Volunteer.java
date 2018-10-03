/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NGOOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.NGOVolunteer.NGOVolunteerJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Kiran
 */
public class Volunteer extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new NGOVolunteerJPanel(userProcessContainer,account,(NGOOrganization)organization,enterprise,business);
    }
    @Override
    public String toString()
    {
        return RoleType.Volunteer.getValue();
    }
}
