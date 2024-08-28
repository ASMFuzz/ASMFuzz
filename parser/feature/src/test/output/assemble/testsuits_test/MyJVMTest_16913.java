import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16913 {

    static GraphicsConfiguration eParam1Param1Param1 = null;

    static Frame eParam1Param1 = new Frame(eParam1Param1Param1);

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 333;

    static WindowEvent e = new WindowEvent(eParam1, eParam2);

    WindowEvent windowClosing(WindowEvent e) {
        e.getWindow().dispose();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16913().windowClosing(e);
    }
}
