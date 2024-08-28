import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_16087 {

    static Robot ro = new Robot();

    static int keyCode = -1880851877;

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
        new MyJVMTest_16087().punchCtrlKey(ro, keyCode);
    }
}
