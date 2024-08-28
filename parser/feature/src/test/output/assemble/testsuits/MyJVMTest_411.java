import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_411 {

    static GraphicsConfiguration eParam1Param1Param1 = null;

    static Frame eParam1Param1 = new Frame(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 110;

    static WindowEvent e = new WindowEvent(eParam1, eParam2);

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
        new MyJVMTest_411().windowIconified(e);
    }
}
