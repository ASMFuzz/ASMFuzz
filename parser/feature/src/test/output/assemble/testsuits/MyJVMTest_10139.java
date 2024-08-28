import java.awt.*;
import java.awt.print.*;
import java.awt.event.*;

public class MyJVMTest_10139 {

    static String evParam1Param1Param1 = "D9%=h:$7^b";

    static GraphicsConfiguration evParam1Param1Param2 = null;

    static Frame evParam1Param1 = new Frame(evParam1Param1Param1, evParam1Param1Param2);

    static Window evParam1 = new Window(evParam1Param1);

    static int evParam2 = 490;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2);

    WindowEvent windowClosed(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10139().windowClosed(ev);
    }
}
