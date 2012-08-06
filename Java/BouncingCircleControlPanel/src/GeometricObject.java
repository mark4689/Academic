import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class GeometricObject {

   private Color color = Color.WHITE;
   private boolean filled;
   private Point center;

   public Color getColor() {
      return color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public boolean isFilled() {
      return filled;
   }

   public void setFilled(boolean filled) {
      this.filled = filled;
   }

   /** Abstract method getArea */
   public abstract double getArea();

   /** Abstract method getPerimeter */
   public abstract double getPerimeter();

   public Point getCenter() {
      return center;
   }

   public void setCenter(Point center) {
      this.center = center;
   }

   public void move (int dx, int dy) {
      center.x += dx;
      center.y += dy;
   }

   public abstract void draw(Graphics g);
}
