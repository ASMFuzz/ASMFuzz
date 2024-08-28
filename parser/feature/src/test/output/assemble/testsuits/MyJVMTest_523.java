import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_523 {

    static Frame eParam1Param1 = new Frame();

    static Window eParam1 = new Window(eParam1Param1);

    static int eParam2 = 689;

    static String eParam3Param1Param1Param1 = "N4R{wBJ<=u";

    static Frame eParam3Param1Param1 = new Frame(eParam3Param1Param1Param1);

    static Window eParam3Param1 = new Window(eParam3Param1Param1);

    static Window eParam3 = new Window(eParam3Param1);

    static WindowEvent e = new WindowEvent(eParam1, eParam2, eParam3);

    static int n = 0;

    WindowEvent this_windowClosing(WindowEvent e) {
        System.exit(0);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_523().this_windowClosing(e);
    }
}
