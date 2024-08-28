import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyJVMTest_553 {

    static FileDialog fd = null;

    static boolean passed = true;

    void test() {
        Robot r;
        try {
            r = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e.getMessage());
        }
        r.delay(500);
        new Thread(new Runnable() {

            public void run() {
                fd.setDirectory(System.getProperty("test.src", "."));
                fd.setVisible(true);
            }
        }).start();
        r.delay(2000);
        r.waitForIdle();
        Component focusedWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
        if (focusedWindow != fd) {
            throw new RuntimeException("Test failed - the file dialog isn't focused window, owner: " + focusedWindow);
        }
        r.waitForIdle();
        r.keyPress(KeyEvent.VK_SPACE);
        r.delay(50);
        r.keyRelease(KeyEvent.VK_SPACE);
        r.delay(1000);
        fd.setVisible(false);
        r.delay(1000);
        r.waitForIdle();
        if (!ISCthrownByFileListTest.passed) {
            throw new RuntimeException("Test failed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_553().run();
    }
}
