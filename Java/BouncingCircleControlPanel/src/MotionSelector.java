/*
The user will use JButtons to stop, (re)start, or reverse the direction of the
bouncing circle.
*/

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MotionSelector extends JPanel implements ActionListener {

    private String[] motions = {"Stop", "Restart", "Reverse"};
    private BouncingCirclePanel bouncingCirclePanel;

    public MotionSelector(BouncingCirclePanel bcp) {
        bouncingCirclePanel = bcp;
        ButtonGroup bg = new ButtonGroup();
        this.setLayout(new GridLayout(3, 1));
        //bouncingCirclePanel.setAlignment(BouncingCirclePanel.CENTER);
        for (int i = 0; i < motions.length; i++) {
            JButton jb = new JButton(motions[i]);
            jb.addActionListener(this);
            this.add(jb);
            bg.add(jb);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String motion = e.getActionCommand();
        if (motion.equals("Stop")) {
            bouncingCirclePanel.stopTimer();
        } else if (motion.equals("Restart")) {
            bouncingCirclePanel.startTimer();
        } else if (motion.equals("Reverse")) {
            bouncingCirclePanel.reverse();
        }
    }
}