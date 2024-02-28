import java.awt.*;
import java.awt.geom.*;

public class Circle extends DrawingObject{

    private Ellipse2D.Double Circle;

    public Circle(double x, double y, int s, Color c) {
        super(x,y,s,c);
        Circle = new Ellipse2D.Double(x1,y1,size,size);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(baseColor);
        g2d.fill(Circle);
    }

    public void outline(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.draw(Circle);
    }
}
