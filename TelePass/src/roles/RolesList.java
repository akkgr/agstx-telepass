/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import avenue.Session;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.RolePermission;
import model.UserRole;
        
/**
 *
 * @author tasos
 */
public class RolesList extends javax.swing.JInternalFrame {

    /**
     * Creates new form RolesList
     */
    public RolesList() {
        em = Session.emf.createEntityManager();
        em.getTransaction().begin();
        initComponents();
        RolePermission rp = Session.GetPermission(Session.ROLES_MODULE);
        this.NewRole.setEnabled(rp.getCanCreate());
        this.EditRole.setEnabled(rp.getCanUpdate());
        this.DeleteRole.setEnabled(rp.getCanDelete());
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

        userRoleQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT u FROM UserRole u");
        userRoleList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(userRoleQuery.getResultList());
        NewRole = new javax.swing.JButton();
        DeleteRole = new javax.swing.JButton();
        EditRole = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ρόλοι Χρηστών");

        NewRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.gif"))); // NOI18N
        NewRole.setText("Νέος");
        NewRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewRoleActionPerformed(evt);
            }
        });

        DeleteRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove.gif"))); // NOI18N
        DeleteRole.setText("Διαγραφή");
        DeleteRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRoleActionPerformed(evt);
            }
        });

        EditRole.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit1.png"))); // NOI18N
        EditRole.setText("Επεξεργασία");
        EditRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditRoleActionPerformed(evt);
            }
        });

        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, userRoleList, jTable1, "RolesBinding");
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${roleName}"));
        columnBinding.setColumnName("Role Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.gif"))); // NOI18N
        cancelButton.setText("Ακύρωση");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.gif"))); // NOI18N
        okButton.setText("Αποθήκευση");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditRole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(okButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton)
                        .addComponent(okButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NewRole)
                        .addComponent(DeleteRole)
                        .addComponent(EditRole)))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewRoleActionPerformed
        UserRole ur = new UserRole();
        em.persist(ur);
        RoleEdit ref  = new RoleEdit(null, true, ur, em);
        ref.setTitle("Νέος Ρόλος");
        ref.setVisible(true);
        if (ref.getReturnStatus() == RoleEdit.RET_OK) {
           userRoleList.add(ur);           
        } else {
            if (ur.getRolePermissionList() != null) {
                for (RolePermission rp : ur.getRolePermissionList()) { 
                    em.remove(rp);
               }
            }
            em.remove(ur);
        }
    }//GEN-LAST:event_NewRoleActionPerformed

    private void DeleteRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRoleActionPerformed
        int s=jTable1.getSelectedRow();
        if (s>=0) {
            UserRole ur = userRoleList.get(jTable1.convertRowIndexToModel(s));
            // Επιβεβαίωση της διαγραφής
            if (ur.getAppUserList() == null || ur.getAppUserList().isEmpty()) {
                // Επιβεβαίωση της διαγραφής
                int choice = JOptionPane.showConfirmDialog(this,
                                          "Διαγραφή του ρόλου " + ur.getRoleName() + ";",
                                          "Επιβεβαίωση διαγραφής ρόλου",
                                          JOptionPane.YES_NO_OPTION);
                if (choice != 0) {
                    return;
                }
                
                try {
                    if (ur.getRolePermissionList() != null) {
                        for (RolePermission rp : ur.getRolePermissionList()) { 
                            em.remove(rp);
                       }
                    }                    
                    em.remove(ur);
                    userRoleList.remove(ur);
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else { 
                JOptionPane.showMessageDialog(this, "Ο ρόλος " + ur.getRoleName() + " δεν μπορεί να διαγραφεί (υπάρχουν χρήστες με το ρόλο αυτό).",
                                          "Σφάλμα",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeleteRoleActionPerformed

    private void EditRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditRoleActionPerformed
        int s = jTable1.getSelectedRow();
        if (s>=0) {
            UserRole ur = userRoleList.get(s);
            RoleEdit ref  = new RoleEdit(null, true, ur, em);
            ref.setTitle("Επεξεργασία Ρόλου: " + ur.getRoleName());
            ref.setVisible(true);
            if (ref.getReturnStatus() == RoleEdit.RET_OK) {
                userRoleList.set(s, ur);           
            } else {
                if (ur.getRolePermissionList() != null) {
                    for (RolePermission rp : ur.getRolePermissionList()) { 
                        em.refresh(rp);
                    }
                }
                em.refresh(ur);
            }
        }
    }//GEN-LAST:event_EditRoleActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        try {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            this.dispose();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
            this.dispose();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteRole;
    private javax.swing.JButton EditRole;
    private javax.swing.JButton NewRole;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton okButton;
    private java.util.List<UserRole> userRoleList;
    private javax.persistence.Query userRoleQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private EntityManager em;
}
