
/**
 * @author clb8@psu.edu   Chuck Burchard
 */
import javax.swing.JFrame;

public class BouncingCircleFrame extends JFrame {

    public static void main(String[] args) {
        new BouncingCircleFrame();
    }

    public BouncingCircleFrame() {
        setTitle("Bouncing Circle");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BouncingCirclePanel cp = new BouncingCirclePanel();
        add(cp);
        ControlPanel cP = new ControlPanel(cp);
        add(cP);
        setVisible(true);
        setResizable(false);
    }

//    public class BouncingCirclePanel extends JPanel implements ActionListener {
//
//        private Circle c;
//        private int dx, dy;
//        private Timer t;
//
//        public BouncingCirclePanel(int setTimer) {
//            super();
//            setBackground(Color.WHITE);
//            c = new Circle();
//            c.setCenter(new Point(300, 300));
//            c.setRadius(50);
//            c.setFilled(true);
//            c.setColor(Color.BLUE);
//            dx = -1;
//            dy = +2;
//
//            t = new Timer(setTimer, this);
//            t.start();
//        }
//
//        public BouncingCirclePanel() {
//            new BouncingCirclePanel(20);
//        }
//
//        public void stopTimer() {
//            this.t.stop();
//        }
//
//        public void startTimer() {
//            this.t.start();
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            c.draw(g);
//        }
//
//        public void actionPerformed(ActionEvent e) {
//            repaint(); // forces a call to paintComponent
//
//            double x = c.getCenter().x;
//            double y = c.getCenter().y;
//            double r = c.getRadius();
//            int w = this.getWidth();
//            int h = this.getHeight();
//
//            if (x - r <= 0) {
//                dx = dx >= 0 ? dx : -dx;
//            } else if (x + r >= w) {
//                dx = dx < 0 ? dx : -dx;
//            } else if (y - r <= 0) {
//                dy = dy >= 0 ? dy : -dy;
//            } else if (y + r >= h) {
//                dy = dy < 0 ? dy : -dy;
//            }
//            c.move(dx, dy);
//        }
//    }
}

