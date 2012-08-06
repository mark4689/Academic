/*
The user will choose one of a group of JRadioButtons to change the speed of the
circle. Allow at least 3 speeds - slow, moderate, and fast. The initial number
of timer ticks per second must correspond to one of these speeds.
*/

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BallSpeed extends JPanel implements ActionListener {
    private String [] speeds = {"Fast", "Moderate", "Slow"};
    private BouncingCirclePanel bouncingCirclePanel;

    public BallSpeed(BouncingCirclePanel bcp){
        bouncingCirclePanel = bcp;
        ButtonGroup bg = new ButtonGroup();
        this.setLayout(new GridLayout(3,1));
        for(int i = 0; i < speeds.length; i++) {
            JRadioButton jrb = new JRadioButton(speeds[i]);
            if (speeds[i].equals("Moderate"))
                jrb.setSelected(true);
            jrb.addActionListener(this);
            this.add(jrb);
            bg.add(jrb);
        }
    }

    public void actionPerformed (ActionEvent e) {
        String speed = e.getActionCommand();

        if (speed.equals("Fast"))
            bouncingCirclePanel.speed(5);
        else if (speed.equals("Moderate"))
            bouncingCirclePanel.speed(20);
        else if (speed.equals("Slow"))
            bouncingCirclePanel.speed(100);
    }
    

}
