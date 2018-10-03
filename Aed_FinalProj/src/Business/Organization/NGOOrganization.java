/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.Volunteer;
import java.util.HashSet;

/**
 *
 * @author Kiran
 */
public class NGOOrganization extends Organization{

    public NGOOrganization() {
        super(Organization.Type.NGO.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles= new HashSet<>();
        roles.add(new Volunteer());
        return roles;
    }
    
}
