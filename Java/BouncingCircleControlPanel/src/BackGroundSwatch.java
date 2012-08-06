/*
The user will use a JColorChooser to change the background color of the
BouncingCirclePanel.
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class BackGroundSwatch extends JPanel implements ActionListener{
    private BouncingCirclePanel bouncingCirclePanel;
    private JButton colorSwatch;

    public BackGroundSwatch(BouncingCirclePanel bcp) {
        bouncingCirclePanel = bcp;
        colorSwatch = new JButton("Color Swatch");
        colorSwatch.setSize(50, 85);
        colorSwatch.addActionListener(this);
        this.add(colorSwatch);
    }

    public void actionPerformed(ActionEvent e) {
        Color newbkgd = JColorChooser.showDialog(null, "Please choose a color: ", Color.white);
        bouncingCirclePanel.setBackground(newbkgd);
    }
}
