import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_8366 {

    static GraphicsConfiguration eParam1Param1Param1Param1Param1 = null;

    static Frame eParam1Param1Param1Param1 = new Frame(eParam1Param1Param1Param1Param1);

    static Window eParam1Param1Param1 = new Window(eParam1Param1Param1Param1);

    static Window eParam1Param1 = new Window(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 104;

    static Frame eParam3Param1 = new Frame();

    static Window eParam3 = new Window(eParam3Param1);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

    static boolean windowIconifiedIsCalled = false;

    static boolean frameIsRepainted = false;

    static JFrame frame = null;

    static JButton button = null;

    RepaintManager windowIconified(WindowEvent e) {
        windowIconifiedIsCalled = true;
        RepaintManager rm = RepaintManager.currentManager(null);
        rm.paintDirtyRegions();
        button.repaint();
        if (!rm.getDirtyRegion(button).isEmpty()) {
            frameIsRepainted = true;
        }
        return rm;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8366().windowIconified(e);
    }
}
