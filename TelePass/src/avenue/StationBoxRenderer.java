/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avenue;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import model.Station;

/**
 *
 * @author Aggelos
 */
public class StationBoxRenderer extends DefaultListCellRenderer{
    @Override
           public Component getListCellRendererComponent(
                   JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
               super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
               if (value instanceof Station) {
                   Station s = (Station)value;
                   setText(s.getDescription());
               }
               return this;
           }
}

