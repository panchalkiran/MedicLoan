/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.RDRecommendation;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author Kiran
 */
public class ResearchAndDevelopmentOrg extends Organization{

    public ResearchAndDevelopmentOrg() {
        super(Organization.Type.ResearchAndDevelopment.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles= new HashSet<>();
        roles.add(new RDRecommendation());
        return roles;
    }
    
}
