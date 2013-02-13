/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avenue;

import java.awt.Window;
import java.awt.event.WindowEvent;

/**
 *
 * @author Aggelos
 */
public class MyWindowEvent extends WindowEvent{
    public boolean exitAndSave;
    public MyWindowEvent(Window source, int id, boolean exitAndSave) {
        super(source, id);
        this.exitAndSave = exitAndSave;
    }
    
}
