/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ResearchAndDevelopmentOrg;
import Business.UserAccount.UserAccount;
import UserInterface.UHCResearcher.UHCResearcherJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Kiran
 */
public class Researcher extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new UHCResearcherJPanel(userProcessContainer,account,organization,enterprise,business);
    }
    @Override
    public String toString()
    {
        return RoleType.Researcher.getValue();
    }
}
