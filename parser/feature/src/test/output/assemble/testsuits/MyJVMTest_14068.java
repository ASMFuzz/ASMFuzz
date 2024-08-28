import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_14068 {

    static Component eParam1 = new Container();

    static int eParam2 = 676;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 271;

    static int eParam5 = 271;

    static int eParam6 = 181;

    static int eParam7 = 956;

    static boolean eParam8 = false;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8);

    static int mouseEnteredCount = 0;

    static int mouseExitedCount = 0;

    static JFrame frame = null;

    void createAndShowGUI() {
        frame = new JFrame("Main Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseEnteredCount++;
            }

            @Override
            public MouseEvent mouseExited(MouseEvent e) {
                mouseExitedCount++;
                return e;
            }
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14068().mouseExited(e);
    }
}
