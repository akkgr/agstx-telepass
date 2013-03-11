/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avenue;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.AppUser;
import model.RolePermission;
/**
 *
 * @author tasos
 */
public class Session {
    
    public static final int USERS_MODULE =1;
    public static final int CUSTOMERS_MODULE =2;
    public static final int PROGRAMS_MODULE =3;
    public static final int TOLL_COLLECTION_MODULE =4;
    public static final int PAYMENTS_MODULE =5;
    public static final int LOG_MODULE =6;
    public static final int ROLES_MODULE =7;
    
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpassPU");
    
    private static AppUser user;
    
    public static AppUser getUser(){
        return user;
    }
        
    public static void setUser(AppUser value){
        user = value;
    }
    
    public static RolePermission GetPermission(int module) {
        for (RolePermission rp : user.getRoleId().getRolePermissionList()){
            if (rp.getModuleId().getId() == module){
                return rp;
            }                
        }
        return null;
    }
    
    public static boolean CheckPermission(int module) {
        if (GetPermission(module) == null) {
            JOptionPane.showMessageDialog(null, "Δεν έχετε δικαίωμα πρόσβασης στην επιλογή.",
                                          "Προσοχή",JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public static void OpenForm(JDesktopPane desktop,JInternalFrame frm, int module)
    {
        if (!CheckPermission(module)) {
            return;
        }
        for (JInternalFrame f : desktop.getAllFrames()) {
            if (f.getTitle() == null ? frm.getTitle() == null : f.getTitle().equals(frm.getTitle())) {
                try {
                    f.setSelected(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Avenue.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            }
        }
        desktop.add(frm);
        frm.setVisible(true);
    }
}
