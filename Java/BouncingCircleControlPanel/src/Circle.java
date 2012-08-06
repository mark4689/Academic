
import java.awt.Graphics;

public class Circle extends GeometricObject {
  private int radius;

  public Circle() {
  }

  public Circle(int radius) {
    this.radius = radius;
  }

  /** Return radius */
  public int getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(int radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  public void draw (Graphics g) {
     g.setColor(getColor());
     int ulx = (int)(getCenter().x - getRadius());
     int uly = (int)(getCenter().y - getRadius());
     if (isFilled())
        g.fillOval (ulx, uly, 2*(int)getRadius(), 2*(int)getRadius());
     else
        g.drawOval (ulx, uly, 2*(int)getRadius(), 2*(int)getRadius());
  }
}
