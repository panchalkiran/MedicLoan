/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author Kiran
 */
public class UniversityHealthCareEnterprise extends Enterprise{

    public UniversityHealthCareEnterprise(String name) {
        super(name, EnterpriseType.UniversityHealthCare);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
       return null;
    }
    
}
