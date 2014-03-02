/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compenents;

import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author HoussemEddine
 */
public class ButtonsPhPanel extends JPanel {
    public final List<JButton> buttons = Arrays.asList(new JButton(new ImageIcon("src/gui/dlt.png")));
 //   public final List<JButton> buttonsDF = Arrays.asList(new JButton("Accepter"),new JButton("Refuser"));
    public ButtonsPhPanel() {
        super();
        setOpaque(true);
        
      //  try {
         //   Image img = ImageIO.read(getClass().getResource("/gui/delete.jpg"));
            for(JButton b: buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
        //    b.setIcon(new ImageIcon(img));
  
            add(b);
        }
   /*         for(JButton b: buttonsDF) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
        //    b.setIcon(new ImageIcon(img));
  
            add(b);
        }*/
            
    //    } catch (IOException ex) {
    //        Logger.getLogger(Frame_Admin.class.getName()).log(Level.SEVERE, null, ex);
     //   }
        
    }
}    
