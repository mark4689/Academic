
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
    private BouncingCirclePanel bouncingCirclePanel;
    private JPanel panelMotion;
    private JPanel panelAll;
    private JPanel panelBallColor;
    private JPanel panelFill;
    private JPanel panelSpeed;
    private JPanel panelRadius;
    private JPanel panelBkgd;
    private JPanel ballProperties;

    public ControlPanel(BouncingCirclePanel bcp){
        bouncingCirclePanel = bcp;

        this.setLayout(new BorderLayout());
        this.add(bouncingCirclePanel);
        

        panelMotion = new JPanel();
        panelMotion.setLayout(new BorderLayout());
        panelMotion.add(new JLabel(" Motion: "), BorderLayout.NORTH);
        panelMotion.add(new MotionSelector(bouncingCirclePanel));

        panelBallColor = new JPanel();
        panelBallColor.setLayout(new BorderLayout());
        panelBallColor.add(new JLabel(" Ball Color: "), BorderLayout.NORTH);
        panelBallColor.add(new BallColorChooser(bouncingCirclePanel));

        panelFill = new JPanel();
        panelFill.add(new FillCircle(bouncingCirclePanel));

        panelSpeed = new JPanel();
        panelSpeed.setLayout(new BorderLayout());
        panelSpeed.add(new JLabel(" Ball Speed: "), BorderLayout.NORTH);
        panelSpeed.add(new BallSpeed(bouncingCirclePanel));

        panelRadius = new JPanel();
        panelRadius.setLayout(new BorderLayout());
        panelRadius.add(new JLabel(" Radius: "), BorderLayout.NORTH);
        panelRadius.add(new BallRadiusSelector(bouncingCirclePanel));

        panelBkgd = new JPanel();
        panelBkgd.setLayout(new BorderLayout());
        panelBkgd.add(new JLabel(" Background Color:"), BorderLayout.NORTH);
        panelBkgd.add(new BackGroundSwatch(bouncingCirclePanel));

        ballProperties = new JPanel();
        ballProperties.setLayout(new BorderLayout());
        ballProperties.add(panelBallColor, BorderLayout.NORTH);
        ballProperties.add(panelFill);

        panelAll = new JPanel();
        panelAll.setLayout(new GridLayout(1,5));


        panelAll.add(panelMotion);
        panelAll.add(ballProperties);
        panelAll.add(panelSpeed);
        panelAll.add(panelRadius);
        panelAll.add(panelBkgd);
        this.add(panelAll, BorderLayout.SOUTH);
    }
}
