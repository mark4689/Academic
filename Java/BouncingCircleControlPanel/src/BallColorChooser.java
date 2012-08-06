/*
The user will choose the color of the bouncing circle from a JComboBox. 
Allow at least red, blue, green, and black as choices.
*/

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

public class BallColorChooser extends JComboBox {
    private BouncingCirclePanel bouncingCirclePanel;
    private String [] colors = {"Red","Blue","Green","Black"};
    private Color [] colorValue = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};

    public BallColorChooser(BouncingCirclePanel bcp){
        bouncingCirclePanel = bcp;
        for(int i = 0; i < colors.length; i++)
            this.addItem(colors[i]);

        this.setSelectedItem("Red");
        bouncingCirclePanel.ballColor(Color.RED);
        this.addItemListener(new ItemListener() {

         public void itemStateChanged(ItemEvent e) {
            bouncingCirclePanel.ballColor(colorValue[getSelectedIndex()]);
         }
      });
    }
}
