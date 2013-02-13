/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avenue;

import model.AppUser;
import model.RolePermission;

/**
 *
 * @author Aggelos
 */
public class Session {
    public static AppUser loginUser;
    public static final int USERS_MODULE =1;
    public static final int CUSTOMERS_MODULE =2;
    public static final int PROGRAMS_MODULE =3;
    public static final int TOLL_COLLECTION_MODULE =4;
    public static final int PAYMENTS_MODULE =5;
    public static final int LOG_MODULE =6;
    
    public Session() {
    }
    
    public static boolean doesSessionUserHasPermission(int permission){
        boolean ret=false;
        if (loginUser.getId()==null){ 
            return false;
        }
        if (loginUser.getRoleId()==null){ 
            return false;
        }
        if (loginUser.getRoleId().getId()==1){ 
            return true;
        }
        if (loginUser.getRoleId().getRolePermissionList()==null){
            return false;
        }
        for (RolePermission rp : loginUser.getRoleId().getRolePermissionList()){
            if (rp.getId() == permission){
                return true;
            }
                
        }
        return ret;
    }

    
    
}
