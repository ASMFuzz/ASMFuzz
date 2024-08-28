import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_6591 {

    static Robot ro = new Robot();

    static int keyCode = 0;

    Robot punchCtrlKey(Robot ro, int keyCode) {
        ro.keyPress(KeyEvent.VK_CONTROL);
        try {
            ro.keyPress(keyCode);
            ro.keyRelease(keyCode);
        } catch (IllegalArgumentException iae) {
            System.err.println("skip probably invalid keyCode " + keyCode);
        }
        ro.keyRelease(KeyEvent.VK_CONTROL);
        ro.delay(200);
        return ro;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6591().punchCtrlKey(ro, keyCode);
    }
}
