/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Researcher;
import Business.Role.Role;
import Business.Role.Volunteer;
import java.util.HashSet;

/**
 *
 * @author Kiran
 */
public class UniversityHealthCareOrganization extends Organization{

    public UniversityHealthCareOrganization() {
        super(Organization.Type.UniversityHealthCare.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
     roles= new HashSet<>();
        roles.add(new Researcher());
        return roles;  
    }
    
}
