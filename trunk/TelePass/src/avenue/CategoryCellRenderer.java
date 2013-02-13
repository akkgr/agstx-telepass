/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avenue;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.VehicleCategory;

/**
 *
 * @author Aggelos
 */

public class CategoryCellRenderer extends DefaultTableCellRenderer {

private static final long serialVersionUID = 1L;

public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row,int col) {

    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
    VehicleCategory vc = (VehicleCategory)table.getModel().getValueAt(row, col);

    if (vc.getDescription().equalsIgnoreCase("ΙΧΕ")) {
        c.setForeground(Color.YELLOW);
    }
    else {
        c.setForeground(Color.WHITE);
    }

    return c;
}
}