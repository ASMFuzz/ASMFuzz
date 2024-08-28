import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MyJVMTest_15633 {

    static Graphics g = new Graphics2D();

    static GraphicsConfiguration graphicsConfig = null;

    static JFrame frame = null;

    static boolean paintComponentCalled = false;

    void initAndShowGUI() {
        frame = new JFrame(graphicsConfig);
        JApplet applet = new JApplet();
        applet.setBackground(new Color(0, 0, 0, 0));
        JPanel panel = new JPanel() {

            protected Graphics paintComponent(Graphics g) {
                paintComponentCalled = true;
                g.setColor(Color.RED);
                g.fillOval(0, 0, getWidth(), getHeight());
                return g;
            }
        };
        panel.setDoubleBuffered(false);
        panel.setOpaque(false);
        applet.add(panel);
        frame.add(applet);
        frame.setBounds(100, 100, 200, 200);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15633().paintComponent(g);
    }
}
