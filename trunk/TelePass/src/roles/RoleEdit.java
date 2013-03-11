/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.Module;
import model.RolePermission;
import model.UserRole;
/**
 *
 * @author tasos
 */
public class RoleEdit extends javax.swing.JDialog {
    
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
        
    /**
     * Creates new form RoleEdit
     */
    public RoleEdit(java.awt.Frame parent, boolean modal, UserRole ur, EntityManager em) {
        super(parent, modal);
        
        this.em = em;
        role = ur;        
        if (ur.getRolePermissionList() != null) {
            permissions = ur.getRolePermissionList();
        } else {
            permissions = new ArrayList<>();
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
    
    public int getReturnStatus() {
        return returnStatus;
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        role.setRolePermissionList(rolePermissionList);
        if (returnStatus == RoleEdit.RET_OK) {
            if (role.getRoleName() == null || role.getRoleName().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Πρέπει να συμπληρώσετε τον Ρόλο.", "TelePass", JOptionPane.ERROR_MESSAGE);
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

        userRole1 = role;
        rolePermissionList = org.jdesktop.observablecollections.ObservableCollections.observableList(permissions);
        jLabel2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        AddPermission = new javax.swing.JButton();
        DeletePermission = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 500));

        jLabel2.setText("Ρόλος");

        userNameField.setName(""); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, userRole1, org.jdesktop.beansbinding.ELProperty.create("${roleName}"), userNameField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, rolePermissionList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${moduleId}"));
        columnBinding.setColumnName("Δικαίωμα");
        columnBinding.setColumnClass(model.Module.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${stationLevelAccess}"));
        columnBinding.setColumnName("Ορατότητα Σταθμού");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${canRetrieve}"));
        columnBinding.setColumnName("Αναζήτηση");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${canCreate}"));
        columnBinding.setColumnName("Εισαγωγή");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${canUpdate}"));
        columnBinding.setColumnName("Επεξεργασία");
        columnBinding.setColumnClass(Boolean.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${canDelete}"));
        columnBinding.setColumnName("Διαγραφή");
        columnBinding.setColumnClass(Boolean.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        AddPermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.gif"))); // NOI18N
        AddPermission.setText("Νέο");
        AddPermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPermissionActionPerformed(evt);
            }
        });

        DeletePermission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.gif"))); // NOI18N
        DeletePermission.setText("Διαγραφή");
        DeletePermission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePermissionActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AddPermission)
                        .addGap(18, 18, 18)
                        .addComponent(DeletePermission)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(okButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userNameField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddPermission)
                    .addComponent(DeletePermission)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void AddPermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPermissionActionPerformed
        // Έλεγχος για το αν υπάρχουν modules για τα οποία δεν έχει οριστεί κάποιο δικαίωμα
        Query q = em.createQuery("select m from Module m");
        
        // Ενημέρωση λίστας με όλα τα modules
        List<Module> mList;
        try { 
            mList = q.getResultList();
        } catch(NoResultException ex) { 
            JOptionPane.showMessageDialog(this, "Μη δυνατή η ανάκτηση των modules!.",
                                          "Σφάλμα",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Αφαίρεση από την λίστα αυτή τα modules για τα οποία έχουν
        // οριστεί δικαιώματα
        for (int i = mList.size()-1; i >= 0; i--) { 
             Module m = mList.get(i);
             for (RolePermission rp : rolePermissionList) { 
                  if (rp.getModuleId().getId().toString().equals(m.getId().toString())) { 
                      mList.remove(m);
                      break;
                  }
             }
        }
        // Έλεγχος του μεγέθους της λίστας
        if (mList.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Έχει οριστεί δικαίωμα για όλα τα modules!.",
                                          "Σφάλμα",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Άνοιγμα οθόνης για επιλογή
        ModuleSelect msd = new ModuleSelect(null, true, mList);
        msd.setVisible(true);
        if (msd.getReturnStatus() == ModuleSelect.RET_OK)
        {
            for (Module m : msd.getSelectedModules()) { 
                         RolePermission rp = new RolePermission();
                         em.persist(rp);
                         rp.setRoleId(role);
                         rp.setModuleId(m);
                         rp.setStationLevelAccess(true);
                         rp.setCanCreate(true);
                         rp.setCanRetrieve(true);
                         rp.setCanUpdate(true);
                         rp.setCanDelete(true);
                         rolePermissionList.add(rp);
                    }
        }
    }//GEN-LAST:event_AddPermissionActionPerformed

    private void DeletePermissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePermissionActionPerformed
        int s = jTable2.getSelectedRow();
        if (s >= 0) {
            RolePermission pr = rolePermissionList.get(jTable2.convertRowIndexToModel(s));
            // Επιβεβαίωση της διαγραφής
            int choice = JOptionPane.showConfirmDialog(this,
                                      "Διαγραφή του δικαιώματος "+ pr.getModuleId().getDescription() +";",
                                      "Επιβεβαίωση διαγραφής δικαιώματος",
                                      JOptionPane.YES_NO_OPTION);
                
            if (choice != 0) {
                return;
            }
            
            rolePermissionList.remove(pr);
            em.remove(pr);
        }
    }//GEN-LAST:event_DeletePermissionActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPermission;
    private javax.swing.JButton DeletePermission;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton okButton;
    private java.util.List<RolePermission> rolePermissionList;
    private javax.swing.JTextField userNameField;
    private model.UserRole userRole1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private int returnStatus = RET_CANCEL;
    private UserRole role;
    private List<RolePermission> permissions;
    private EntityManager em; 
}