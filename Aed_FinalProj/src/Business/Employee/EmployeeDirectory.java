/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Kiran
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
     
   public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
       InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
}
    
    public Employee createEmployee(String name,String email, String address){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmailId(email);
        employee.setAddress(address);
        employeeList.add(employee);
        return employee;
    }
    
}
