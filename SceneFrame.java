import javax.swing.*;

public class SceneFrame {
    
    private JFrame frame;
    private SceneCanvas sc;

    public SceneFrame() {
        frame = new JFrame();
        sc = new SceneCanvas();
    }

    public void setUpGUI() {
        frame.setTitle("Midterm Project - Aguilar - Paderna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(sc);
        sc.setUpListeners();
        sc.setFocusable(true);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
