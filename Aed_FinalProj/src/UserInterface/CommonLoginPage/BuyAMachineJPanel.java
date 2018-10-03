/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CommonLoginPage;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Machine.Machine;
import Business.Order.MasterOrderCatalog;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.Organization;
import Business.Supplier.Supplier;
import Business.UserAccount.UserAccount;
import UserInterface.DoctorRole.DoctorWorkAreaJPanel;
import UserInterface.LabAssistant.LabAssistantWorkAreaJPanel;
import UserInterface.NGOVolunteer.NGOVolunteerJPanel;
import UserInterface.PatientRole.PatientWorkAreaJPanel;
import UserInterface.UHCResearcher.UHCResearcherJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Komal
 */
public class BuyAMachineJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BuyAMachineJPanel
     */
    private JPanel container;
    private UserAccount ua;
    private Organization org;
    private Enterprise enterprise;
    private EcoSystem system;
    private Order o;
    private Machine machine;
    private Boolean isCheckout = false;
    private MasterOrderCatalog moc;
    private double roi;

    public BuyAMachineJPanel(JPanel container, UserAccount ua, Organization org, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.container = container;
        this.ua = ua;
        this.org = org;
        this.enterprise = enterprise;
        this.system = system;
        lblUserName.setText(ua.getEmployee().getName());
        populateMachineType();
        populateMachineTable();

        lblUserName.setText(this.ua.getEmployee().getName());
        if (!isCheckout) {
            o = new Order();
        }
    }

    public void populateMachineType() {
        jcbMachineType.removeAllItems();
        for (Machine.MachineType type : Machine.MachineType.values()) {
            jcbMachineType.addItem(type);
        }
    }

    public void populateTable(Machine.MachineType type) {
        DefaultTableModel model = (DefaultTableModel) tblMachineCatalog.getModel();
        model.setRowCount(0);

        for (Supplier s : system.getSupplierCatalog().getSupplierList()) {
            for (Machine m : s.getMachineList().getMachineCatalog()) {
                if (m.getType().equalsIgnoreCase(type.getValue())) {
                    Object[] row = new Object[4];
                    row[0] = m;
                    row[1] = m.getCode();
                    row[2] = m.getQuantity();
                    row[3] = m.getPrice();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateMachineTable() {

        DefaultTableModel model = (DefaultTableModel) tblMachineCatalog.getModel();
        model.setRowCount(0);

        for (Supplier s : system.getSupplierCatalog().getSupplierList()) {
            for (Machine m : s.getMachineList().getMachineCatalog()) {
                Object[] row = new Object[4];
                row[0] = m;
                row[1] = m.getCode();
                row[2] = m.getQuantity();
                row[3] = m.getPrice();
                model.addRow(row);
            }
        }
    }

    public void populateOrder() {
        DecimalFormat df = new DecimalFormat("#.00");
        DefaultTableModel dtm = (DefaultTableModel) tblAddedtoCart.getModel();
        dtm.setRowCount(0);
        for (OrderItem oi : o.getOrderItemList()) {
            Object row[] = new Object[8];
            row[0] = oi;
            row[1] = oi.getMachine().getCode();
            row[2] = oi.getOrderItemQuantity();
            row[3] = oi.getMachine().getInterestRate() + "%";
            row[4] = df.format(oi.getMachine().getLoan().getTotalOrderItemAmount());
            row[5] = df.format(oi.getMachine().getLoan().getInstallmentsPaidPrice());

            Date oDate = new Date();
            DateFormat oDateFormat = new SimpleDateFormat("MM-dd-yyyy");
            String szDate = oDateFormat.format(oDate);
            row[6] = szDate;

            dtm.addRow(row);
        }
    }

    public int totalAmount() {
        int sum = 0;
        for (OrderItem oi : o.getOrderItemList()) {
            sum += (oi.getOrderItemQuantity() * oi.getSalesPrice());
        }
        return sum;
    }

///Adding Installment Function
    public static double calculateMonthlyPayment(int loanAmount, int termInYears, double interestRate) {

        interestRate /= 100.0;
        double monthlyRate = interestRate / 12.0;
        int termInMonths = termInYears;

        double monthlyPayment = (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
        return monthlyPayment;
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
        btnAdtoCart = new javax.swing.JButton();
        lblCustomername1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSpinnerQty = new javax.swing.JSpinner();
        jSpinnerMonths = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        lblCustomername6 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMachineCatalog = new javax.swing.JTable();
        lblCustomername3 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnCheckout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAddedtoCart = new javax.swing.JTable();
        jcbMachineType = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Activity:");
        add(jLabel6);
        jLabel6.setBounds(1, 1, 56, 16);

        btnAdtoCart.setBackground(new java.awt.Color(0, 153, 153));
        btnAdtoCart.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAdtoCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAdtoCart.setText("Add to Cart");
        btnAdtoCart.setMaximumSize(new java.awt.Dimension(200, 200));
        btnAdtoCart.setMinimumSize(new java.awt.Dimension(200, 200));
        btnAdtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdtoCartActionPerformed(evt);
            }
        });
        add(btnAdtoCart);
        btnAdtoCart.setBounds(720, 300, 180, 30);

        lblCustomername1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername1.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername1.setText("Machine Details");
        add(lblCustomername1);
        lblCustomername1.setBounds(63, 1, 101, 16);

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<<");
        btnBack.setMaximumSize(new java.awt.Dimension(200, 200));
        btnBack.setMinimumSize(new java.awt.Dimension(200, 200));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(40, 530, 55, 39);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Select Quantity:");
        add(jLabel11);
        jLabel11.setBounds(270, 270, 120, 16);

        jSpinnerQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jSpinnerQty.setValue(1);
        add(jSpinnerQty);
        jSpinnerQty.setBounds(470, 260, 48, 30);

        jSpinnerMonths.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        add(jSpinnerMonths);
        jSpinnerMonths.setBounds(470, 300, 46, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("Select Installment Months");
        add(jLabel13);
        jLabel13.setBounds(270, 310, 180, 16);

        lblCustomername6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblCustomername6.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername6.setText("(Number of Months)");
        add(lblCustomername6);
        lblCustomername6.setBounds(530, 310, 115, 16);

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(0, 102, 0));
        lblUserName.setText("*user Details");
        add(lblUserName);
        lblUserName.setBounds(41, 28, 85, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("User:");
        add(jLabel9);
        jLabel9.setBounds(1, 28, 34, 16);

        tblMachineCatalog.setBackground(new java.awt.Color(204, 255, 204));
        tblMachineCatalog.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblMachineCatalog.setForeground(new java.awt.Color(102, 0, 102));
        tblMachineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Machine", "Code", "Availability", "Unit Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMachineCatalog);

        add(jScrollPane1);
        jScrollPane1.setBounds(150, 80, 770, 160);

        lblCustomername3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCustomername3.setForeground(new java.awt.Color(0, 102, 0));
        lblCustomername3.setText("Machine Catagory");
        add(lblCustomername3);
        lblCustomername3.setBounds(280, 36, 117, 20);

        btnRemove.setBackground(new java.awt.Color(0, 153, 153));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove Item");
        btnRemove.setMaximumSize(new java.awt.Dimension(200, 200));
        btnRemove.setMinimumSize(new java.awt.Dimension(200, 200));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove);
        btnRemove.setBounds(690, 500, 177, 30);

        btnCheckout.setBackground(new java.awt.Color(0, 153, 153));
        btnCheckout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCheckout.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckout.setText("Checkout");
        btnCheckout.setMaximumSize(new java.awt.Dimension(200, 200));
        btnCheckout.setMinimumSize(new java.awt.Dimension(200, 200));
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });
        add(btnCheckout);
        btnCheckout.setBounds(890, 500, 180, 30);

        tblAddedtoCart.setBackground(new java.awt.Color(204, 255, 204));
        tblAddedtoCart.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tblAddedtoCart.setForeground(new java.awt.Color(102, 0, 102));
        tblAddedtoCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Machine", "Code", "Quantity", "Rate of Interest", "Total Amount", "Installment Amount", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblAddedtoCart);

        add(jScrollPane2);
        jScrollPane2.setBounds(130, 370, 1030, 110);

        jcbMachineType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbMachineType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMachineTypeActionPerformed(evt);
            }
        });
        add(jcbMachineType);
        jcbMachineType.setBounds(420, 30, 178, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdtoCartActionPerformed
        // TODO add your handling code here:
        // btnViewDetails.setEnabled(true);
        int selectedRow = tblMachineCatalog.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        } else {

            machine = (Machine) tblMachineCatalog.getValueAt(selectedRow, 0);
            int fetchQty = (Integer) jSpinnerQty.getValue();
            int timePeriod = (Integer) jSpinnerMonths.getValue();
            if (fetchQty <= machine.getQuantity()) {
                DecimalFormat df = new DecimalFormat("#.00");

                boolean alreadyPresent = false;

                for (OrderItem oi : o.getOrderItemList()) {
                    if (oi.getMachine() == machine) {

                        int oldAvail = machine.getQuantity();
                        int newAvail = oldAvail - fetchQty;
                        machine.setQuantity(newAvail);
                        oi.setOrderItemQuantity(fetchQty + oi.getOrderItemQuantity());

                        int oldtimeP = oi.getMachine().getLoan().getTimePeriod();
                        int newtimeP = (Integer) jSpinnerMonths.getValue();
                        machine.getLoan().setTimePeriod(newtimeP);
                        alreadyPresent = true;

                        int totalPrice = machine.getPrice() * oi.getOrderItemQuantity();
                        if (totalPrice < 2000) {
                            roi = 3;
                            machine.setInterestRate(roi);
                            machine.getLoan().setInstallmentsPaidPrice(calculateMonthlyPayment(totalPrice, machine.getLoan().getTimePeriod(), roi));
                            System.out.println(machine.getLoan().getInstallmentsPaidPrice() + "lllllllllllllllllll");

                        } else if (totalPrice > 2000 || totalPrice < 10000) {
                            roi = 5;
                            machine.setInterestRate(roi);
                            machine.getLoan().setInstallmentsPaidPrice(calculateMonthlyPayment(totalPrice, machine.getLoan().getTimePeriod(), roi));

                        } else {
                            roi = 7;
                            machine.setInterestRate(roi);
                            machine.getLoan().setInstallmentsPaidPrice(calculateMonthlyPayment(totalPrice, timePeriod, roi));

                        }

                        double newtotalAmount = machine.getLoan().getInstallmentsPaidPrice() * machine.getLoan().getTimePeriod();
                        double remaining = (machine.getLoan().getInstallmentsPaidPrice() * machine.getLoan().getTimePeriod()) - machine.getLoan().getInstallmentsPaidPrice();
                        machine.getLoan().setTotalOrderItemAmount(newtotalAmount);

                        machine.getLoan().setTotalOrderItemAmount(newtotalAmount);
                        oi.setSalesPrice(newtotalAmount + oi.getSalesPrice());
                        oi.getMachine().getLoan().setRemainingAmountTobePaid(remaining);

                        oi.setSalesPrice(newtotalAmount);
                        oi.setRemainingforOrder(remaining);

                        populateOrder();
                        populateMachineTable();
                        break;
                    }
                }
                if (!alreadyPresent) {
                    int oldAvail = machine.getQuantity();
                    int newavail = oldAvail - fetchQty;
                    machine.setQuantity(newavail);
                    machine.getLoan().setTimePeriod(timePeriod);

                    OrderItem orderItem = o.addOrderItem();
                    orderItem.setMachine(machine);
                    orderItem.setOrderItemQuantity(fetchQty);
                    orderItem.setdOfPurchase(machine.getDateOfPurchaseInString());
                    orderItem.setNdOfInstallment(machine.getNextInstallmentDate());

                    int totalPrice = machine.getPrice() * orderItem.getOrderItemQuantity();

                    if (totalPrice < 2000) {
                        roi = 3;
                        machine.setInterestRate(roi);
                        machine.getLoan().setInstallmentsPaidPrice(calculateMonthlyPayment(totalPrice, machine.getLoan().getTimePeriod(), roi));

                    } else if (totalPrice > 2000 || totalPrice < 10000) {
                        roi = 5;
                        machine.setInterestRate(roi);
                        machine.getLoan().setInstallmentsPaidPrice(calculateMonthlyPayment(totalPrice, machine.getLoan().getTimePeriod(), roi));

                    } else {
                        roi = 7;
                        machine.setInterestRate(roi);
                        machine.getLoan().setInstallmentsPaidPrice(calculateMonthlyPayment(totalPrice, timePeriod, roi));

                    }

                    double newtotalAmount = machine.getLoan().getInstallmentsPaidPrice() * machine.getLoan().getTimePeriod();
                    double remaining = newtotalAmount - machine.getLoan().getInstallmentsPaidPrice();

                    machine.getLoan().setTotalOrderItemAmount(newtotalAmount);
                    machine.getLoan().setRemainingAmountTobePaid(remaining);

                    orderItem.setSalesPrice(newtotalAmount);
                    orderItem.setRemainingforOrder(remaining);

                    populateMachineTable();
                    populateOrder();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Quantity must be greater than Available items", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnAdtoCartActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        if (ua.getRole().toString().equals("Doctor")) {
            container.remove(this);
            Component[] componentArray = container.getComponents();
            Component component = componentArray[componentArray.length - 1];
            DoctorWorkAreaJPanel dwjp = (DoctorWorkAreaJPanel) component;
            dwjp.populateRequestTable();
            CardLayout layout = (CardLayout) container.getLayout();
            layout.previous(container);
        }
        if (ua.getRole().toString().equals("LabAssistant")) {
            container.remove(this);
            Component[] componentArray = container.getComponents();
            Component component = componentArray[componentArray.length - 1];
            LabAssistantWorkAreaJPanel lwjp = (LabAssistantWorkAreaJPanel) component;
            lwjp.populateRequestTable();
            CardLayout layout = (CardLayout) container.getLayout();
            layout.previous(container);
        }
        if (ua.getRole().toString().equals("Volunteer")) {
            container.remove(this);
            Component[] componentArray = container.getComponents();
            Component component = componentArray[componentArray.length - 1];
            NGOVolunteerJPanel nvjp = (NGOVolunteerJPanel) component;
            nvjp.populateRequestTable();
            CardLayout layout = (CardLayout) container.getLayout();
            layout.previous(container);
        }
        if (ua.getRole().toString().equals("Patient")) {
            container.remove(this);
            Component[] componentArray = container.getComponents();
            Component component = componentArray[componentArray.length - 1];
            PatientWorkAreaJPanel pwjp = (PatientWorkAreaJPanel) component;
            pwjp.populateRequestTable();
            CardLayout layout = (CardLayout) container.getLayout();
            layout.previous(container);
        }
        if (ua.getRole().toString().equals("Researcher")) {
            container.remove(this);
            Component[] componentArray = container.getComponents();
            Component component = componentArray[componentArray.length - 1];
            UHCResearcherJPanel uhcrjp = (UHCResearcherJPanel) component;
            uhcrjp.populateRequestTable();
            CardLayout layout = (CardLayout) container.getLayout();
            layout.previous(container);
        }

    }//GEN-LAST:event_btnBackActionPerformed


    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int row = tblAddedtoCart.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            OrderItem oi = (OrderItem) tblAddedtoCart.getValueAt(row, 0);
            int oldAvail = oi.getMachine().getQuantity();
            int oldQty = oi.getOrderItemQuantity();
            int newQty = oldQty + oldAvail;
            oi.getMachine().setQuantity(newQty);
            o.removeOrderItem(oi);
            JOptionPane.showMessageDialog(null, "OrderItem removed from the Cart");
        }
        populateOrder();
        populateMachineTable();

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
        if (o.getOrderItemList().size() > 0) {
            moc = system.getMasterOrderCatalog();
            moc.addOrder(o);
            int totalSum = totalAmount();
            o.setTotalRevenue(totalSum);
            o.setUa(ua);
            populateOrder();
            isCheckout = true;
            CheckOutJPanel checkOutJPanel = new CheckOutJPanel(container, ua, org, o, system);
            container.add("CheckOut JPanel", checkOutJPanel);
            CardLayout layout = (CardLayout) container.getLayout();
            layout.next(container);

            o = new Order();

        } else {
            JOptionPane.showMessageDialog(null, "Cart is empty!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckoutActionPerformed


    private void jcbMachineTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMachineTypeActionPerformed
        // TODO add your handling code here:
        Machine.MachineType type = (Machine.MachineType) jcbMachineType.getSelectedItem();
        if (type != null) {
            populateTable(type);
        }
    }//GEN-LAST:event_jcbMachineTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdtoCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerMonths;
    private javax.swing.JSpinner jSpinnerQty;
    private javax.swing.JComboBox jcbMachineType;
    private javax.swing.JLabel lblCustomername1;
    private javax.swing.JLabel lblCustomername3;
    private javax.swing.JLabel lblCustomername6;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblAddedtoCart;
    private javax.swing.JTable tblMachineCatalog;
    // End of variables declaration//GEN-END:variables
}
