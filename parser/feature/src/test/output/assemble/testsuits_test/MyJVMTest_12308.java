import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12308 {

    static String evParam1Param1Param1 = "L,OZy-h$jD";

    static GraphicsConfiguration evParam1Param1Param2 = null;

    static Frame evParam1Param1 = new Frame(evParam1Param1Param1, evParam1Param1Param2);

    static Window evParam1 = new Window(evParam1Param1);

    static int evParam2 = 326;

    static WindowEvent ev = new WindowEvent(evParam1, evParam2);

    WindowEvent windowClosing(WindowEvent ev) {
        System.exit(0);
        return ev;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12308().windowClosing(ev);
    }
}
