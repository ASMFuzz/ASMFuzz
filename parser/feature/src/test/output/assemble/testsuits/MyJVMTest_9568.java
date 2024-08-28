import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9568 {

    static String eParam1Param1Param1 = "m,U'r*9IG8";

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Frame eParam1Param1 = new Frame(eParam1Param1Param1, eParam1Param1Param2);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 837;

    static GraphicsConfiguration eParam3Param1Param1Param1Param1Param1Param1 = null;

    static Frame eParam3Param1Param1Param1Param1Param1 = new Frame(eParam3Param1Param1Param1Param1Param1Param1);

    static Window eParam3Param1Param1Param1Param1 = new Window(eParam3Param1Param1Param1Param1Param1);

    static Window eParam3Param1Param1Param1 = new Window(eParam3Param1Param1Param1Param1);

    static Window eParam3Param1Param1 = new Window(eParam3Param1Param1Param1);

    static Window eParam3Param1 = new Window(eParam3Param1Param1);

    static GraphicsConfiguration eParam3Param2 = null;

    static Window eParam3 = new Window(eParam3Param1, eParam3Param2);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

    static boolean windowIconifiedIsCalled = false;

    static boolean frameIsRepainted = false;

    static JFrame frame = null;

    static JButton button = null;

    void run() {
        frame = new JFrame();
        button = new JButton("HI");
        frame.getContentPane().add(button);
        frame.addWindowListener(new WindowAdapter() {

            public RepaintManager windowIconified(WindowEvent e) {
                windowIconifiedIsCalled = true;
                RepaintManager rm = RepaintManager.currentManager(null);
                rm.paintDirtyRegions();
                button.repaint();
                if (!rm.getDirtyRegion(button).isEmpty()) {
                    frameIsRepainted = true;
                }
                return rm;
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9568().windowIconified(e);
    }
}
