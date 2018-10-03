/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Machine;

import Business.Machine.Machine.MachineType;
import java.util.ArrayList;

/**
 *
 * @author Kiran
 */
public class MachineCatalog {
    
    private ArrayList<Machine> machineCatalog;
    
    public MachineCatalog(){
       machineCatalog= new ArrayList<Machine>();
                
    }

    public ArrayList<Machine> getMachineCatalog() {
        return machineCatalog;
    }

    public void setMachineCatalog(ArrayList<Machine> machineCatalog) {
        this.machineCatalog = machineCatalog;
    }

    public Machine addMachine() {
        Machine machine = new Machine();
        machineCatalog.add(machine);
        return machine;
    }
    
    public void removeMachine(Machine machine) {
        machineCatalog.remove(machine);
    }
    
}
