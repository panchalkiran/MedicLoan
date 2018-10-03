/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.UHCResearcher;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Machine.Machine;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MachineRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.CommonLoginPage.BuyAMachineJPanel;
import UserInterface.CommonLoginPage.CallTechnicianJPanel;
import UserInterface.CommonLoginPage.SuggestionJPanel;
import UserInterface.CommonLoginPage.PayInstallmentJPanel;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Komal
 */
public class UHCResearcherJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private JPanel container;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount ua;
    private EcoSystem system;
    private ArrayList<String> countOfType;
    private HashMap<String, Integer> hm= new HashMap<>();
   
    
    public UHCResearcherJPanel(JPanel container, UserAccount ua, Organization organization, Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.container=container;
        this.enterprise=enterprise;
        this.ua=ua;
        this.organization=organization;
        this.system=system;
        machineDetails.hide();
        populateRequestTable();
       
    }

    public void populateRequestTable() {

        boolean flag;
        countOfType= new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) tblDocMachineReq.getModel();
        dtm.setRowCount(0);

        DecimalFormat df = new DecimalFormat("#.00");
        flag = false;
        for (WorkRequest req : ua.getWorkQueue().getWorkRequestList()) {
            if (req instanceof MachineRequest) {

                Object row[] = new Object[10];
                
                countOfType.add(req.getMachine().getType());
                row[0] = ((MachineRequest) req).getRequestId();
                row[1] = req.getMachine().getName();
                row[2] = req.getMachine().getCode();
                row[3] = ((MachineRequest) req);
                row[4] = df.format(((MachineRequest) req).getTotalPrice());
                row[5] = df.format(((MachineRequest) req).getPaidAmount());
                row[6] = df.format(((MachineRequest) req).getRemainingAmount());

                int noOfInstallment = ((MachineRequest) req).getNoOfInstallmentsRemaining();

                row[7] = noOfInstallment;
                row[8] = ((MachineRequest) req).getDateOfPurchaseInString();
                if (noOfInstallment > 0) {
                    row[9] = ((MachineRequest) req).getNextDateOfInstallmentInString();
                } else {
                    row[9] = "-";
                }
                dtm.addRow(row);
                flag = true;
            }

        }
        populateCount();
        if (flag == false) {
            btnViewDet.setEnabled(false);
            btnNotifyTech.setEnabled(false);
            btnPayInstallment.setEnabled(false);
            btnSuggestion.setEnabled(false);
        } else {
            btnViewDet.setEnabled(true);
            btnNotifyTech.setEnabled(true);
            btnPayInstallment.setEnabled(true);
            btnSuggestion.setEnabled(true);
        }

    }

    public void populateCount() {
        for (Machine.MachineType t : Machine.MachineType.values()) {
            int occurencies = Collections.frequency(countOfType, t.getValue());
            if (t == Machine.MachineType.Anesthetic) {
                hm.put("Anesthetic", occurencies);
            }
            if (t == Machine.MachineType.Dental) {
                hm.put("Dental", occurencies);
            }
            if (t == Machine.MachineType.Dressings) {
                hm.put("Dressings", occurencies);
            }
            if (t == Machine.MachineType.Emergency) {
                hm.put("Emergency", occurencies);
            }
            if (t == Machine.MachineType.MedicalTesting) {
                hm.put("MedicalTesting", occurencies);
            }
            if (t == Machine.MachineType.Ophthalmic) {
                hm.put("Ophthalmic", occurencies);
            }
            if (t == Machine.MachineType.Orthopedic) {
                hm.put("Orthopedic", occurencies);
            }
            if (t == Machine.MachineType.SmallMachines) {
                hm.put("SmallMachines", occurencies);
            }
            if (t == Machine.MachineType.Surgical) {
                hm.put("Surgical", occurencies);
            }
            if (t == Machine.MachineType.Veterinary) {
                hm.put("Veterinary", occurencies);
            }

        }
        String highestValue = getMapKeyWithHighestValue(hm);
        ua.setHighestMachineType(highestValue);
    }

    public String getMapKeyWithHighestValue(HashMap<String, Integer> map) {
        String keyWithHighestVal = "";

        // getting the maximum value in the Hashmap
        int maxValueInMap = (Collections.max(map.values()));

        //iterate through the map to get the key that corresponds to the maximum value in the Hashmap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {  // Iterate through hashmap
            if (entry.getValue() == maxValueInMap) {

                keyWithHighestVal = entry.getKey();     // this is the key which has the max value
            }

        }
        return keyWithHighestVal;
    }
    
    public void populateLabel() {
        DecimalFormat df = new DecimalFormat("#.00");
        int selectedrow = tblDocMachineReq.getSelectedRow();
        if (selectedrow >= 0) {
            machineDetails.show();
            MachineRequest machinereq = (MachineRequest) tblDocMachineReq.getValueAt(selectedrow, 3);
            lblMachineName.setText(machinereq.getMachine().getName());
            lblCode.setText(machinereq.getMachine().getCode());
            lblQty.setText(String.valueOf(machinereq.getRequestQuantity()));
            lblPrise.setText(String.valueOf(df.format(machinereq.getTotalPrice())));
            lblMoneyPaid.setText(String.valueOf(df.format(machinereq.getPaidAmount())));
            lblRemainingAmount.setText(String.valueOf(df.format(machinereq.getRemainingAmount())));
            lblPurchaseDate.setText(machinereq.getDateOfPurchaseInString());
            lblNextInstallmentDue.setText(machinereq.getNextDateOfInstallmentInString());

        } else {
            JOptionPane.showMessageDialog(null, "Please select Machine from Table ", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDocMachineReq = new javax.swing.JTable();
        btnViewDet = new javax.swing.JButton();
        machineDetails = new javax.swing.JInternalFrame();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblQty = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblMoneyPaid = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPrise = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblMachineName = new javax.swing.JLabel();
        lblPurchaseDate = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblNextInstallmentDue = new javax.swing.JLabel();
        lblRemainingAmount = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();
        btnNotifyTech = new javax.swing.JButton();
        btnSuggestion = new javax.swing.JButton();
        btnPayInstallment = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Activity:");
        add(jLabel6);
        jLabel6.setBounds(10, 15, 56, 16);

        lblDoctor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDoctor.setForeground(new java.awt.Color(0, 102, 0));
        lblDoctor.setText("Researcher");
        add(lblDoctor);
        lblDoctor.setBounds(72, 15, 120, 16);

        lbl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl.setForeground(new java.awt.Color(0, 102, 0));
        lbl.setText("My purchase");
        add(lbl);
        lbl.setBounds(10, 54, 83, 16);

        tblDocMachineReq.setBackground(new java.awt.Color(204, 255, 204));
        tblDocMachineReq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblDocMachineReq.setForeground(new java.awt.Color(102, 0, 102));
        tblDocMachineReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "RequestId", "Machine", "Code", "Quantity", "Total Price", "Money Paid", "Remaining ", "no of Installment", "Last Payment On", "Next Installment Due"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDocMachineReq);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 1170, 190);

        btnViewDet.setBackground(new java.awt.Color(0, 153, 153));
        btnViewDet.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnViewDet.setForeground(new java.awt.Color(255, 255, 255));
        btnViewDet.setText("View Details");
        btnViewDet.setMaximumSize(new java.awt.Dimension(200, 200));
        btnViewDet.setMinimumSize(new java.awt.Dimension(200, 200));
        btnViewDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetActionPerformed(evt);
            }
        });
        add(btnViewDet);
        btnViewDet.setBounds(40, 310, 180, 50);

        machineDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        machineDetails.setClosable(true);
        machineDetails.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        machineDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        machineDetails.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        machineDetails.setFocusCycleRoot(false);
        machineDetails.setName("machineDetails"); // NOI18N
        machineDetails.setOpaque(true);
        machineDetails.setVisible(true);
        machineDetails.getContentPane().setLayout(null);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("Machine Purchase Detalis");
        machineDetails.getContentPane().add(jLabel20);
        jLabel20.setBounds(10, 0, 165, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Machine");
        machineDetails.getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 30, 53, 16);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("Date of purchase");
        machineDetails.getContentPane().add(jLabel14);
        jLabel14.setBounds(200, 30, 112, 16);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("Remaining");
        machineDetails.getContentPane().add(jLabel12);
        jLabel12.setBounds(200, 90, 66, 16);

        lblQty.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblQty.setForeground(new java.awt.Color(0, 102, 0));
        lblQty.setText("*qty");
        machineDetails.getContentPane().add(lblQty);
        lblQty.setBounds(90, 90, 30, 16);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Quantity");
        machineDetails.getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 90, 56, 16);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Money Paid");
        machineDetails.getContentPane().add(jLabel10);
        jLabel10.setBounds(200, 60, 74, 16);

        lblMoneyPaid.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblMoneyPaid.setForeground(new java.awt.Color(0, 102, 0));
        lblMoneyPaid.setText("*money Paid");
        machineDetails.getContentPane().add(lblMoneyPaid);
        lblMoneyPaid.setBounds(350, 60, 82, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Price");
        machineDetails.getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 120, 32, 16);

        lblPrise.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblPrise.setForeground(new java.awt.Color(0, 102, 0));
        lblPrise.setText("*amount");
        machineDetails.getContentPane().add(lblPrise);
        lblPrise.setBounds(90, 120, 57, 16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Code");
        machineDetails.getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 60, 32, 16);

        lblCode.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCode.setForeground(new java.awt.Color(0, 102, 0));
        lblCode.setText("*MCode");
        machineDetails.getContentPane().add(lblCode);
        lblCode.setBounds(90, 60, 51, 16);

        lblMachineName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblMachineName.setForeground(new java.awt.Color(0, 102, 0));
        lblMachineName.setText("*Machine");
        machineDetails.getContentPane().add(lblMachineName);
        lblMachineName.setBounds(90, 30, 61, 16);

        lblPurchaseDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblPurchaseDate.setForeground(new java.awt.Color(0, 102, 0));
        lblPurchaseDate.setText("*purchase Date");
        machineDetails.getContentPane().add(lblPurchaseDate);
        lblPurchaseDate.setBounds(350, 30, 103, 16);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("Next Installment Due");
        machineDetails.getContentPane().add(jLabel13);
        jLabel13.setBounds(200, 120, 135, 16);

        lblNextInstallmentDue.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblNextInstallmentDue.setForeground(new java.awt.Color(0, 102, 0));
        lblNextInstallmentDue.setText("*nextDue");
        machineDetails.getContentPane().add(lblNextInstallmentDue);
        lblNextInstallmentDue.setBounds(350, 120, 110, 16);

        lblRemainingAmount.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblRemainingAmount.setForeground(new java.awt.Color(0, 102, 0));
        lblRemainingAmount.setText("*Remaining money");
        machineDetails.getContentPane().add(lblRemainingAmount);
        lblRemainingAmount.setBounds(350, 90, 121, 16);

        add(machineDetails);
        machineDetails.setBounds(390, 310, 550, 220);

        btnBuy.setBackground(new java.awt.Color(0, 153, 153));
        btnBuy.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBuy.setForeground(new java.awt.Color(255, 255, 255));
        btnBuy.setText("Buy new Machine");
        btnBuy.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBuy.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });
        add(btnBuy);
        btnBuy.setBounds(1030, 290, 180, 50);

        btnNotifyTech.setBackground(new java.awt.Color(0, 153, 153));
        btnNotifyTech.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnNotifyTech.setForeground(new java.awt.Color(255, 255, 255));
        btnNotifyTech.setText("Notify Technician");
        btnNotifyTech.setMaximumSize(new java.awt.Dimension(200, 200));
        btnNotifyTech.setMinimumSize(new java.awt.Dimension(200, 200));
        btnNotifyTech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotifyTechActionPerformed(evt);
            }
        });
        add(btnNotifyTech);
        btnNotifyTech.setBounds(1030, 360, 180, 50);

        btnSuggestion.setBackground(new java.awt.Color(0, 153, 153));
        btnSuggestion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSuggestion.setForeground(new java.awt.Color(255, 255, 255));
        btnSuggestion.setText("Suggestions");
        btnSuggestion.setMaximumSize(new java.awt.Dimension(200, 200));
        btnSuggestion.setMinimumSize(new java.awt.Dimension(200, 200));
        btnSuggestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuggestionActionPerformed(evt);
            }
        });
        add(btnSuggestion);
        btnSuggestion.setBounds(1030, 430, 180, 50);

        btnPayInstallment.setBackground(new java.awt.Color(0, 153, 153));
        btnPayInstallment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnPayInstallment.setForeground(new java.awt.Color(255, 255, 255));
        btnPayInstallment.setText("Pay Installment");
        btnPayInstallment.setMaximumSize(new java.awt.Dimension(200, 200));
        btnPayInstallment.setMinimumSize(new java.awt.Dimension(200, 200));
        btnPayInstallment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayInstallmentActionPerformed(evt);
            }
        });
        add(btnPayInstallment);
        btnPayInstallment.setBounds(1030, 500, 180, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetActionPerformed
        // TODO add your handling code here:
        populateLabel();
    }//GEN-LAST:event_btnViewDetActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
        BuyAMachineJPanel addcartjp = new BuyAMachineJPanel(container,ua,organization,enterprise,system);
        container.add("Reseacher Buy A Machine JPanel", addcartjp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnNotifyTechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotifyTechActionPerformed
        // TODO add your handling code here:

        int selectedrow = tblDocMachineReq.getSelectedRow();
        if (selectedrow >= 0) {
            populateLabel();
            MachineRequest machineReq = (MachineRequest) tblDocMachineReq.getValueAt(selectedrow, 3);
            if (machineReq.getStatus().equals("Completed")) {
                CallTechnicianJPanel calltechjp = new CallTechnicianJPanel(container, machineReq, ua, organization, enterprise, system);
                container.add("Reseacher Call Technician JPanel", calltechjp);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
            } else {
                JOptionPane.showMessageDialog(null, "MachineRequest not processed!Cannot call a Technician", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select Machine from Table ", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnNotifyTechActionPerformed

    private void btnSuggestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuggestionActionPerformed
        // TODO add your handling code here:
        SuggestionJPanel suggJP = new SuggestionJPanel(container,ua, organization, enterprise, system);
        container.add("Reseacher Suggestion JPanel", suggJP);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnSuggestionActionPerformed

    private void btnPayInstallmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayInstallmentActionPerformed
        // TODO add your handling code here:
        PayInstallmentJPanel payInstallmentjp = new PayInstallmentJPanel(container, ua, organization, enterprise, system);
        container.add("Reseacher Pay Installment JPanel", payInstallmentjp);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnPayInstallmentActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnNotifyTech;
    private javax.swing.JButton btnPayInstallment;
    private javax.swing.JButton btnSuggestion;
    private javax.swing.JButton btnViewDet;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblMachineName;
    private javax.swing.JLabel lblMoneyPaid;
    private javax.swing.JLabel lblNextInstallmentDue;
    private javax.swing.JLabel lblPrise;
    private javax.swing.JLabel lblPurchaseDate;
    private javax.swing.JLabel lblQty;
    private javax.swing.JLabel lblRemainingAmount;
    private javax.swing.JInternalFrame machineDetails;
    private javax.swing.JTable tblDocMachineReq;
    // End of variables declaration//GEN-END:variables
}
