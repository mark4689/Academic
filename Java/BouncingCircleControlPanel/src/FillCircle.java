/*
The user will check/uncheck a JCheckBox.to specify whether the circle is filled.
This box is initially unchecked.
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class FillCircle extends JPanel implements ActionListener {
    private BouncingCirclePanel bouncingCirclePanel;
    private JCheckBox fill;

    public FillCircle(BouncingCirclePanel bcp) {
        bouncingCirclePanel = bcp;
        fill = new JCheckBox("Fill Ball");
        fill.addActionListener(this);
        this.add(fill);
        fill.setSelected(bouncingCirclePanel.ballFilled());
    }
        
       public void actionPerformed(ActionEvent e) {
            bouncingCirclePanel.fillBall(fill.isSelected());
        }
    
}

