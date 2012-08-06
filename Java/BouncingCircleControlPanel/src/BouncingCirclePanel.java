/*
 *
 * @author: Mark Kiddo Jr.
 * CMPSC221 Assignment 6
 * Completed 29 October 2009
 * Originally Compiled In Mac OS X 10.6.1 using NetBeans 6.7.1
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.JPanel;


public class BouncingCirclePanel extends JPanel implements ActionListener {

    private Circle c;
    private int dx, dy;
    private Timer t;

    public BouncingCirclePanel(int setTimer) {
        super();
        Random gen = new Random();
        setBackground(Color.WHITE);
        c = new Circle();
        c.setCenter(new Point(300, 300));
        c.setRadius(gen.nextInt(90)+10);
        c.setFilled(true);
        c.setColor(Color.BLUE);
        dx = gen.nextInt(2) + 1;
        dy = gen.nextInt(2) + 1;

        t = new Timer(setTimer, this);
        t.start();
    }


    public BouncingCirclePanel() {
        this(20);
    }

    public void reverse() {
        dx = -dx;
        dy = -dy;
    }

    public void stopTimer() {
        this.t.stop();
    }

    public void startTimer() {
        this.t.start();
    }

    public void ballColor(Color pigment){
        c.setColor(pigment);
    }

    public void fillBall(boolean set) {
        c.setFilled(set);
    }

    public boolean ballFilled() {
        return c.isFilled();
    }

    public void speed(int ticks) {
        t.stop();
        t = new Timer(ticks, this);
        t.start();
    }

    public int ballRadius() {
        return c.getRadius();
    }

    public void setBallRadius( int rad ) {
        c.setRadius(rad);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        c.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        repaint(); // forces a call to paintComponent

        double x = c.getCenter().x;
        double y = c.getCenter().y;
        double r = c.getRadius();
        int w = this.getWidth();
        int h = this.getHeight();

        if (x - r <= 0) {
            dx = dx >= 0 ? dx : -dx;
        } else if (x + r >= w) {
            dx = dx < 0 ? dx : -dx;
        } else if (y - r <= 0) {
            dy = dy >= 0 ? dy : -dy;
        } else if (y + r >= h) {
            dy = dy < 0 ? dy : -dy;
        }
        c.move(dx, dy);
    }
}


