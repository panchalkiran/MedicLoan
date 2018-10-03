/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Doctor;
import Business.Role.LabAssistant;
import Business.Role.Patient;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author Kiran
 */
public class HospitalOrganization extends Organization{

    public HospitalOrganization() {
        super(Organization.Type.Hospital.getValue());
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles= new HashSet<>();
        roles.add(new Doctor());
        roles.add(new Patient());
        roles.add(new LabAssistant());
        return roles;
    }
    
}
