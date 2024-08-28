import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_15676 {

    static Component eParam1 = new Container();

    static int eParam2 = 124;

    static ComponentEvent e = new ComponentEvent(eParam1, eParam2);

    static boolean moved = false;

    static boolean resized = false;

    void run() {
        JFrame f = new JFrame("JFrame");
        JButton b = new JButton("JButton");
        f.add(b);
        new JOptionPane().createInternalFrame(b, "Test").addComponentListener(new ComponentAdapter() {

            public void componentMoved(ComponentEvent e) {
                moved = true;
                System.out.println(e);
            }

            public ComponentEvent componentResized(ComponentEvent e) {
                resized = true;
                System.out.println(e);
                return e;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15676().componentResized(e);
    }
}
