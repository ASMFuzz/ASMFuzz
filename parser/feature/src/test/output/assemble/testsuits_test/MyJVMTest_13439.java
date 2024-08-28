import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13439 {

    static int buttonId = 0;

    static Frame frame = new Frame("MouseEvent Test Frame");

    static Point mousePosition = null;

    int postMouseEventOldCtor(int buttonId) {
        MouseEvent meOld = new MouseEvent(frame, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), MouseEvent.BUTTON1_DOWN_MASK, mousePosition.x, mousePosition.y, 1, false, buttonId);
        frame.dispatchEvent((AWTEvent) meOld);
        return buttonId;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13439().postMouseEventOldCtor(buttonId);
    }
}
