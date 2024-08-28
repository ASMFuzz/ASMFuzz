import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_12910 {

    static Component eParam1 = new Container();

    static int eParam2 = 922;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 994;

    static int eParam5 = 19;

    static int eParam6 = 766;

    static int eParam7 = 858;

    static boolean eParam8 = true;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8);

    static JFrame frame = null;

    static boolean mouseDragged = false;

    void createAndShowGUI() {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        panel.addMouseMotionListener(new MouseAdapter() {

            @Override
            public MouseEvent mouseDragged(MouseEvent e) {
                mouseDragged = true;
                return e;
            }
        });
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12910().mouseDragged(e);
    }
}
