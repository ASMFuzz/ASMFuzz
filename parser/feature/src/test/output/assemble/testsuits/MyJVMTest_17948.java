import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_17948 {

    static String eParam1Param1Param1 = "H<C:e\">sLE";

    static GraphicsConfiguration eParam1Param1Param2 = null;

    static Frame eParam1Param1 = new Frame(eParam1Param1Param1, eParam1Param1Param2);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 368;

    static WindowEvent e = new WindowEvent(eParam1, eParam2);

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
        new MyJVMTest_17948().windowIconified(e);
    }
}
