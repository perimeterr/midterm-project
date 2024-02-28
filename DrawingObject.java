import java.awt.*;

public abstract class DrawingObject {
    protected double x1;
    protected double y1;
    protected double x2;
    protected double y2;
    protected double cx;
    protected double cy;
    protected int size;
    protected Color baseColor;

    protected int keyFrame = 0;
    final int MAX_KEYFRAMES = 7;

    static int velocity = 1;

    public DrawingObject() {}

    public DrawingObject(double x, double y, int s) {
        x1 = x;
        y1 = y;
        size = s;
    }

    public DrawingObject(double x, double y, int s, Color c) {
        x1 = x;
        y1 = y;
        size = s;
        baseColor = c;

        cx = x1 + (size / 2);
        cy = y1 + (size / 2);
    }

    public void draw(Graphics2D g2d) {}

    public void outline(Graphics2D g2d) {}

    public void moveRight() {
        x1 += 10 + (0.25 * velocity);
    }

    public void moveLeft() {
        x1 -= 10 - (0.25 * velocity);
    }

    public void increaseVelocity() {
        velocity += 5;
    }   

    public void decreaseVelocity() {
        velocity -= 5;
    }

    public void resetVelocity() {
        velocity = 1;
    }

    public void nextKeyFrame() {
        if (keyFrame < MAX_KEYFRAMES) {
            keyFrame += 1;
        } else {
            keyFrame = 0;
        }
    }
}
