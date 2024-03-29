/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.Card;
import model.Customer;
import model.Vehicle;

/**
 *
 * @author tasos
 */
public class CustomerEdit extends javax.swing.JDialog {
    
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    public CustomerEdit(java.awt.Frame parent, boolean modal, Customer cust, EntityManager em) {
        super(parent, modal);
        this.em = em;
        customer1=cust;
        if (cust.getVehicleList() != null) {
            vehicles = cust.getVehicleList();
        } else {
            vehicles = new ArrayList<>();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/pass.jpg")));
        
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        customer1.setVehicleList(VehicleList);
        if (returnStatus == CustomerEdit.RET_OK) {
            if (customer1.getLName() == null || customer1.getLName().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Πρέπει να συμπληρώσετε το Επώνυμο.", "TelePass", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (customer1.getFName() == null || customer1.getFName().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Πρέπει να συμπληρώσετε το Όνομα.", "TelePass", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        setVisible(false);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        customer2 = customer1;
        VehicleList = org.jdesktop.observablecollections.ObservableCollections.observableList(vehicles);
        onomaLabel = new javax.swing.JLabel();
        eponimoLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        tkLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        adtLabel = new javax.swing.JLabel();
        afmLabal = new javax.swing.JLabel();
        onomaTextField = new javax.swing.JTextField();
        eponimoTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        tkTextField = new javax.swing.JTextField();
        cityTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        adtTextField = new javax.swing.JTextField();
        afmTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        VehicleTable = new javax.swing.JTable();
        NewVehicle = new javax.swing.JButton();
        DeleteVechicle = new javax.swing.JButton();
        EditVehicle = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${vehicleList}"), customer2, org.jdesktop.beansbinding.BeanProperty.create("vehicleList"));
        bindingGroup.addBinding(binding);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("diaxirisipelath");
        setResizable(false);

        onomaLabel.setText("Όνομα");

        eponimoLabel.setText("Επώνυμο");

        addressLabel.setText("Διεύθυνση");

        tkLabel.setText("ΤΚ");

        cityLabel.setText("Πόλη");

        phoneLabel.setText("Τηλέφωνο");

        emailLabel.setText("e-mail");

        adtLabel.setText("ΑΔΤ");

        afmLabal.setText("ΑΦΜ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${FName}"), onomaTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "fname");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${LName}"), eponimoTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "lname");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${address}"), addressTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "address");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${zipCode}"), tkTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "tk");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${city}"), cityTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "city");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${phone}"), phoneTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "phone");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${email}"), emailTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "email");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${adt}"), adtTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "adt");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, customer2, org.jdesktop.beansbinding.ELProperty.create("${afm}"), afmTextField, org.jdesktop.beansbinding.BeanProperty.create("text"), "afm");
        bindingGroup.addBinding(binding);

        VehicleTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, VehicleList, VehicleTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${categoryId}"));
        columnBinding.setColumnName("Κατηγορία");
        columnBinding.setColumnClass(model.VehicleCategory.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${factoryName}"));
        columnBinding.setColumnName("Εταιρεία");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${modelType}"));
        columnBinding.setColumnName("Τύπος");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${colour}"));
        columnBinding.setColumnName("Χρώμα");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${regNumber}"));
        columnBinding.setColumnName("Αρ. Κυκλοφορίας");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cardId}"));
        columnBinding.setColumnName("Αρ. Κάρτας");
        columnBinding.setColumnClass(model.Card.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(VehicleTable);

        NewVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.gif"))); // NOI18N
        NewVehicle.setText("Νέο");
        NewVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewVehicleActionPerformed(evt);
            }
        });

        DeleteVechicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.gif"))); // NOI18N
        DeleteVechicle.setText("Διαγραφή");
        DeleteVechicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteVechicleActionPerformed(evt);
            }
        });

        EditVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit1.png"))); // NOI18N
        EditVehicle.setText("Επεξεργασία");
        EditVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditVehicleActionPerformed(evt);
            }
        });

        cancelButton.setLabel("Άκυρο");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setLabel("Επιστροφή");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(eponimoLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(eponimoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(onomaLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(onomaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(cityLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(adtLabel)
                                                .addComponent(emailLabel))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(adtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(phoneLabel)
                                        .addComponent(tkLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tkTextField)
                                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(addressLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(afmLabal)
                                        .addGap(18, 18, 18)
                                        .addComponent(afmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NewVehicle)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteVechicle)
                        .addGap(18, 18, 18)
                        .addComponent(EditVehicle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eponimoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(eponimoLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(onomaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(onomaLabel)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cityLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tkLabel)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adtLabel)
                    .addComponent(adtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(afmTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(afmLabal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(okButton)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NewVehicle)
                        .addComponent(DeleteVechicle)
                        .addComponent(EditVehicle)))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewVehicleActionPerformed
        Vehicle v = new Vehicle();
        em.persist(v);
        v.setCustId(customer2); 
        Card c = new Card();
        em.persist(c);
        c.setBalance(0d); 
        v.setCardId(c);
        VehicleImport vif = new VehicleImport(null,true,v,em);
        vif.setTitle("Νέο Όχημα");
        vif.setVisible(true);
        if (vif.getReturnStatus() == VehicleImport.RET_OK) {
            VehicleList.add(v);
        } else {
            em.remove(c);
            em.remove(v);
        }
    }//GEN-LAST:event_NewVehicleActionPerformed

    private void EditVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditVehicleActionPerformed
        int s = VehicleTable.getSelectedRow();
        if (s >= 0) {
            Vehicle v = VehicleList.get(s);
            VehicleImport vif = new VehicleImport(null,true,v,em);
            vif.setTitle("Επεξργασία Οχήματος: " + v.getRegNumber());
            vif.setVisible(true);
            if (vif.getReturnStatus() == VehicleImport.RET_OK) {
                VehicleList.set(s,v);
            } else {
                em.refresh(v);
                em.refresh(v.getCardId());
            }
            
        }
    }//GEN-LAST:event_EditVehicleActionPerformed

    private void DeleteVechicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteVechicleActionPerformed
        int s = VehicleTable.getSelectedRow();
        if (s >= 0) {
            Vehicle v = VehicleList.get(VehicleTable.convertRowIndexToModel(s));
            // Έλεγχος για το αν το όχημα μπορεί όντως να διαγραφεί
            if (v.getCardId().getCollectionList().isEmpty()) {
                // Επιβεβαίωση της διαγραφής
                int choice = JOptionPane.showConfirmDialog(this,
                                          "Διαγραφή του συγκεκριμένου οχήματος;",
                                          "Επιβεβαίωση διαγραφής οχήματος",
                                          JOptionPane.YES_NO_OPTION);
                
                if (choice != 0) {
                    return;
                }
                
                VehicleList.remove(v);
                em.remove(v.getCardId());
                em.remove(v);                
            } else { 
                JOptionPane.showMessageDialog(this, "Το όχημα δεν μπορεί να διαγραφεί (διελεύσεις >0).",
                                          "Σφάλμα",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeleteVechicleActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteVechicle;
    private javax.swing.JButton EditVehicle;
    private javax.swing.JButton NewVehicle;
    private java.util.List<Vehicle> VehicleList;
    private javax.swing.JTable VehicleTable;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JLabel adtLabel;
    private javax.swing.JTextField adtTextField;
    private javax.swing.JLabel afmLabal;
    private javax.swing.JTextField afmTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private model.Customer customer2;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel eponimoLabel;
    private javax.swing.JTextField eponimoTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel onomaLabel;
    private javax.swing.JTextField onomaTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel tkLabel;
    private javax.swing.JTextField tkTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
    private Customer customer1;
    private List<Vehicle> vehicles;
    private EntityManager em;
}
