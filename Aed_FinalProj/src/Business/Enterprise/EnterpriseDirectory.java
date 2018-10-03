/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Kiran
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name);
            System.out.println("Hospital Enterprise created");
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.MachineManagement){
            enterprise = new MachineManagementEnterprise(name);
            System.out.println("MachineManagement Enterprise created");
            enterpriseList.add(enterprise);
        }
        else  if (type == Enterprise.EnterpriseType.NGO){
            enterprise = new NGOEnterprise(name);
            System.out.println("NGO Enterprise created");
            enterpriseList.add(enterprise);
        }
        else  if (type == Enterprise.EnterpriseType.Supplier){
            enterprise = new SupplierEnterprise(name);
            System.out.println("Supplier Enterprise created");
            enterpriseList.add(enterprise);
        }
        else  if (type == Enterprise.EnterpriseType.UniversityHealthCare){
            enterprise = new UniversityHealthCareEnterprise(name);
            System.out.println("UHC Enterprise created");
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
