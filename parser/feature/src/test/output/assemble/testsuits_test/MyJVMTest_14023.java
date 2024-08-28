import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14023 {

    static String weParam1Param1Param1Param1Param1 = "9mDla|B2b(";

    static GraphicsConfiguration weParam1Param1Param1Param1Param2 = null;

    static Frame weParam1Param1Param1Param1 = new Frame(weParam1Param1Param1Param1Param1, weParam1Param1Param1Param1Param2);

    static Window weParam1Param1Param1 = new Window(weParam1Param1Param1Param1);

    static GraphicsConfiguration weParam1Param1Param2 = null;

    static Window weParam1Param1 = new Window(weParam1Param1Param1, weParam1Param1Param2);

    static GraphicsConfiguration weParam1Param2 = null;

    static Window weParam1 = new Window(weParam1Param1, weParam1Param2);

    static int weParam2 = 885;

    static WindowEvent we = new WindowEvent(weParam1, weParam2);

    static String[] s = { "Choice 1", "Choice 2", "unselected choices", "what choices do I have?", "Will I pick the same thing in the future?" };

    static boolean passed = false;

    WindowEvent windowClosing(WindowEvent we) {
        System.err.println("Test passed");
        passed = true;
        return we;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14023().windowClosing(we);
    }
}
