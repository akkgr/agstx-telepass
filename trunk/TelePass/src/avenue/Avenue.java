/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avenue;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author tasos
 */
public class Avenue extends javax.swing.JFrame {

    enum TileType {

        TILE_HORIZONTAL, TILE_VERTICAL, TILE_CASCADE, TILE_SQUARE
        
    };
    /**
     * Creates new form MainForm
     */    
    public Avenue() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("images/pass.jpg")));
        this.setLocationRelativeTo(null);        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Avenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Avenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Avenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Avenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogInForm lgf = new LogInForm(null, true);
                lgf.setVisible(true);
                if (lgf.getReturnStatus() == LogInForm.RET_OK) {
                    new Avenue().setVisible(true);
                }
                else
                {
                    System.exit(0);
                }
            }
        });
    }
    
    private void deiconifyInternalFrames() {
        final int numComps = desktopPane.getComponentCount();
        int count = 0;
        while (count < numComps) {
            final Component component = desktopPane.getComponent(count);
            if (component instanceof JInternalFrame.JDesktopIcon) {
                try {
                    ((JInternalFrame.JDesktopIcon) component).getInternalFrame().setIcon(false);
                    count = 0;
                } catch (PropertyVetoException e) {
                    // What to do !
                } finally {
                    count++;
                }
            } else {
                count++;
            }
        }
    }
    
    private void arrangeCurrentWindow(TileType format) {

        /*
         * get the component count at the xc frame layer as only interest in
         * xcFrame nothing else
         */
        final JInternalFrame[] frames = desktopPane.getAllFramesInLayer(JLayeredPane.DEFAULT_LAYER);

        final Dimension dim = desktopPane.getSize();

        deiconifyInternalFrames();

        switch (format) {
            case TILE_HORIZONTAL: {
                int vertSize = dim.height / frames.length;
                for (int i = 0; i < frames.length; i++) {
                    frames[i].setSize(new Dimension(dim.width, vertSize));
                    frames[i].setLocation(0, i * vertSize);
                }
                break;
            }
            case TILE_VERTICAL: {
                int horizSize = dim.width / frames.length;
                for (int i = 0; i < frames.length; i++) {
                    frames[i].setSize(new Dimension(horizSize, dim.height));
                    frames[i].setLocation(i * horizSize, 0);
                }
                break;
            }
            case TILE_CASCADE: {
                for (int i = 0; i < frames.length; i++) {
                    frames[i].setSize(new Dimension(dim.height / 2, dim.height / 2));
                    frames[i].setLocation(40 * i, 40 * i);
                }
                break;
            }
            case TILE_SQUARE: {
                int hCount = frames.length / 2 + 1;
                if (hCount >= 3) {
                    hCount = 2;
                }
                int vCount = 1;
                if (frames.length > 2) {
                    vCount = 2;
                }
                int vertSize = dim.height / vCount;
                int horizSize = dim.width / hCount;

                for (int i = 0; i < vCount; i++) {
                    for (int j = 0; j < hCount; j++) {
                        if (i * 2 + j >= frames.length) {
                            break;
                        }
                        JInternalFrame frame = frames[i * 2 + j];
                        frame.setSize(new Dimension(horizSize, vertSize));
                        frame.setLocation(j * horizSize, i * vertSize);
                    }
                }
            }
        }
        desktopPane.validate();

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

        appUser1 = Session.getUser();
        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        ManagerMenu = new javax.swing.JMenu();
        UsersMenuItem = new javax.swing.JMenuItem();
        CustomersMenuItem = new javax.swing.JMenuItem();
        RolesMenuItem = new javax.swing.JMenuItem();
        ProgramsMenuItem = new javax.swing.JMenuItem();
        TollMenu = new javax.swing.JMenu();
        PassMenuItem = new javax.swing.JMenuItem();
        PayMenuItem = new javax.swing.JMenuItem();
        historyMenu = new javax.swing.JMenu();
        CardHistoryMenuItem = new javax.swing.JMenuItem();
        CustHistoryMenuItem = new javax.swing.JMenuItem();
        windowMenu = new javax.swing.JMenu();
        cascadeMenuItem = new javax.swing.JMenuItem();
        tileVerticalMI = new javax.swing.JMenuItem();
        tileHorizontalMI = new javax.swing.JMenuItem();
        tileGridMI = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TelePass");

        desktopPane.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setText("Χρήστης:");
        jPanel1.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, appUser1, org.jdesktop.beansbinding.ELProperty.create("${userName}"), jLabel1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jLabel1);

        jLabel3.setText("Σταθμός:");
        jPanel1.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, appUser1, org.jdesktop.beansbinding.ELProperty.create("${stationId.description}"), jLabel4, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jPanel1.add(jLabel4);

        ManagerMenu.setMnemonic('f');
        ManagerMenu.setText("Διαχείριση");

        UsersMenuItem.setMnemonic('o');
        UsersMenuItem.setText("Χρήστες");
        UsersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersMenuItemActionPerformed(evt);
            }
        });
        ManagerMenu.add(UsersMenuItem);

        CustomersMenuItem.setMnemonic('s');
        CustomersMenuItem.setText("Πελάτες");
        CustomersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomersMenuItemActionPerformed(evt);
            }
        });
        ManagerMenu.add(CustomersMenuItem);

        RolesMenuItem.setMnemonic('a');
        RolesMenuItem.setText("Ρόλοι");
        RolesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RolesMenuItemActionPerformed(evt);
            }
        });
        ManagerMenu.add(RolesMenuItem);

        ProgramsMenuItem.setMnemonic('x');
        ProgramsMenuItem.setText("Προγράμματα");
        ProgramsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgramsMenuItemActionPerformed(evt);
            }
        });
        ManagerMenu.add(ProgramsMenuItem);

        menuBar.add(ManagerMenu);

        TollMenu.setMnemonic('e');
        TollMenu.setText("Διόδια");

        PassMenuItem.setMnemonic('t');
        PassMenuItem.setText("Διέλευση");
        PassMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassMenuItemActionPerformed(evt);
            }
        });
        TollMenu.add(PassMenuItem);

        PayMenuItem.setMnemonic('y');
        PayMenuItem.setText("Πληρωμές");
        PayMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayMenuItemActionPerformed(evt);
            }
        });
        TollMenu.add(PayMenuItem);

        menuBar.add(TollMenu);

        historyMenu.setMnemonic('h');
        historyMenu.setText("Ιστορικό");

        CardHistoryMenuItem.setMnemonic('c');
        CardHistoryMenuItem.setLabel("Πληρωμών");
        CardHistoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardHistoryMenuItemActionPerformed(evt);
            }
        });
        historyMenu.add(CardHistoryMenuItem);

        CustHistoryMenuItem.setMnemonic('a');
        CustHistoryMenuItem.setLabel("Διελεύσεων");
        CustHistoryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustHistoryMenuItemActionPerformed(evt);
            }
        });
        historyMenu.add(CustHistoryMenuItem);

        menuBar.add(historyMenu);

        windowMenu.setText("Window");

        cascadeMenuItem.setMnemonic('C');
        cascadeMenuItem.setText("Tile Cascade");
        cascadeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cascadeMenuItemActionPerformed(evt);
            }
        });
        windowMenu.add(cascadeMenuItem);

        tileVerticalMI.setText("Tile Vertical");
        tileVerticalMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileVerticalMIActionPerformed(evt);
            }
        });
        windowMenu.add(tileVerticalMI);

        tileHorizontalMI.setText("Tile Horizontal");
        tileHorizontalMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileHorizontalMIActionPerformed(evt);
            }
        });
        windowMenu.add(tileHorizontalMI);

        tileGridMI.setText("Tile Grid");
        tileGridMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tileGridMIActionPerformed(evt);
            }
        });
        windowMenu.add(tileGridMI);

        menuBar.add(windowMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 503, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProgramsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgramsMenuItemActionPerformed
        programs.ProgramsList frm = new programs.ProgramsList();
        Session.OpenForm(desktopPane,frm,Session.PROGRAMS_MODULE);
    }//GEN-LAST:event_ProgramsMenuItemActionPerformed

    private void UsersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersMenuItemActionPerformed
        users.UsersList frm = new users.UsersList();
        Session.OpenForm(desktopPane,frm,Session.USERS_MODULE);
    }//GEN-LAST:event_UsersMenuItemActionPerformed

    private void CardHistoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardHistoryMenuItemActionPerformed
        history.PayHistory frm = new history.PayHistory();
        Session.OpenForm(desktopPane,frm,Session.LOG_MODULE);
    }//GEN-LAST:event_CardHistoryMenuItemActionPerformed

    private void RolesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RolesMenuItemActionPerformed
        roles.RolesList frm = new roles.RolesList();
        Session.OpenForm(desktopPane,frm,Session.ROLES_MODULE);        
    }//GEN-LAST:event_RolesMenuItemActionPerformed

    private void cascadeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cascadeMenuItemActionPerformed
        arrangeCurrentWindow(TileType.TILE_CASCADE);
    }//GEN-LAST:event_cascadeMenuItemActionPerformed

    private void tileVerticalMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tileVerticalMIActionPerformed
        arrangeCurrentWindow(TileType.TILE_VERTICAL);
    }//GEN-LAST:event_tileVerticalMIActionPerformed

    private void tileHorizontalMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tileHorizontalMIActionPerformed
        arrangeCurrentWindow(TileType.TILE_HORIZONTAL);
    }//GEN-LAST:event_tileHorizontalMIActionPerformed

    private void tileGridMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tileGridMIActionPerformed
        arrangeCurrentWindow(TileType.TILE_SQUARE);
    }//GEN-LAST:event_tileGridMIActionPerformed

    private void CustomersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomersMenuItemActionPerformed
        customers.CustomerList frm = new customers.CustomerList();
        Session.OpenForm(desktopPane,frm,Session.CUSTOMERS_MODULE);
    }//GEN-LAST:event_CustomersMenuItemActionPerformed

    private void PassMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassMenuItemActionPerformed
        tolls.PassForm frm = new tolls.PassForm();
        Session.OpenForm(desktopPane,frm,Session.TOLL_COLLECTION_MODULE);
    }//GEN-LAST:event_PassMenuItemActionPerformed

    private void PayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayMenuItemActionPerformed
        if (!Session.CheckPermission(Session.PAYMENTS_MODULE)) {
            return;
        }
        tolls.PayForm frm = new tolls.PayForm(null,true,null);
        frm.setVisible(true);
    }//GEN-LAST:event_PayMenuItemActionPerformed

    private void CustHistoryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustHistoryMenuItemActionPerformed
        history.PassHistory frm = new history.PassHistory();
        Session.OpenForm(desktopPane,frm,Session.LOG_MODULE);
    }//GEN-LAST:event_CustHistoryMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CardHistoryMenuItem;
    private javax.swing.JMenuItem CustHistoryMenuItem;
    private javax.swing.JMenuItem CustomersMenuItem;
    private javax.swing.JMenu ManagerMenu;
    private javax.swing.JMenuItem PassMenuItem;
    private javax.swing.JMenuItem PayMenuItem;
    private javax.swing.JMenuItem ProgramsMenuItem;
    private javax.swing.JMenuItem RolesMenuItem;
    private javax.swing.JMenu TollMenu;
    private javax.swing.JMenuItem UsersMenuItem;
    private model.AppUser appUser1;
    private javax.swing.JMenuItem cascadeMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu historyMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem tileGridMI;
    private javax.swing.JMenuItem tileHorizontalMI;
    private javax.swing.JMenuItem tileVerticalMI;
    private javax.swing.JMenu windowMenu;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
