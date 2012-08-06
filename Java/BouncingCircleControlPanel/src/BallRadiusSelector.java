/*
The user will use a JSlider to change the radius of the circle. Allow radii
from 10 to 100, inclusive. THe initial setting on the JSlider must correspond to
the initial randomly generated radius of the circle.
*/

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BallRadiusSelector extends JPanel implements ChangeListener {
    private BouncingCirclePanel bouncingCirclePanel;
    private JSlider radiusSlider;

    public BallRadiusSelector(BouncingCirclePanel bcp) {
        bouncingCirclePanel = bcp;
        radiusSlider = new JSlider();
        radiusSlider.setMinimum(10);
        radiusSlider.setMaximum(100);
        radiusSlider.setValue(bouncingCirclePanel.ballRadius());
        radiusSlider.setMinorTickSpacing(5);
        radiusSlider.setMajorTickSpacing(10);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setPaintLabels(true);
        radiusSlider.addChangeListener(this);
        this.add(radiusSlider);
    }

    public void stateChanged (ChangeEvent e){
        int size = radiusSlider.getValue();

        bouncingCirclePanel.setBallRadius(size);
    }

}
