import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class SceneCanvas extends JComponent{
    private int width = 800;
    private int height = 600;

    private ArrayList<DrawingObject> shapesList;

    private Timer animationTimer;

    Killua killua;

    public SceneCanvas() {
        this.setPreferredSize(new Dimension(width,height));
        
        shapesList = new ArrayList<DrawingObject>();

        killua = new Killua(370,170,60);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.setRenderingHints(rh);

        Rectangle2D.Double bg = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(new Color(136,195,247));
        g2d.fill(bg);

        shapesList.add(killua);
        /*for (DrawingObject s : shapesList) {
            s.draw(g2d);
        }*/

        killua.draw(g2d);
    }

    private void moveRight() {
        killua.moveRight();
        killua.increaseVelocity();
        killua.bounce();
        repaint();
    }
    
    private void moveLeft() {
        killua.moveLeft();
        killua.decreaseVelocity();
        killua.bounce();
        repaint();
    }

    public void setUpListeners() {
        KeyListener kl = new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'a':
                        moveLeft();
                        break;
                    case 'd':
                        moveRight();
                        break;
                }
                animationTimer.start();
            }
            @Override
            public void keyReleased(KeyEvent e) {
                killua.resetYPos();
                killua.resetVelocity();
            }
        };
        this.addKeyListener(kl);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                /*for (DrawingObject s : shapesList) {
                    s.nextKeyFrame();
                }*/
                killua.nextKeyFrame();
            }
        };
        animationTimer = new Timer(200,al);
        animationTimer.setRepeats(true);
    }

}