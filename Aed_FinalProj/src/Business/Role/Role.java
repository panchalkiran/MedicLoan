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
import javax.swing.JPanel;

/**
 *
 * @author Kiran
 */
public abstract class Role {
    
    public enum RoleType{
        
        
        Doctor("Doctor"),
        HospitalAdmin("HospitalAdmin"),
        LabAdmin("LabAdmin"),
        LabAssistant("LabAssistant"),
        LoanManager("LoanManager"),
        MachineManagementAdmin("MachineManagementAdmin"),
        MachineManager("MachineManager"),
        NGOAdmin("NGOAdmin"),
        Patient("Patient"),
        RDFeedback("RDFeedback"),
        RDRecommendation("RDRecommendation"),
        Researcher("Researcher"),
        Supplier("Supplier"),
        SupplierAdmin("SupplierAdmin"),
        SystemAdmin("SystemAdmin"),
        Technician("Technician"),
        UniversityHealthCareAdmin("UniversityHealthCareAdmin"),
        Volunteer("Volunteer");
        
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    
}
