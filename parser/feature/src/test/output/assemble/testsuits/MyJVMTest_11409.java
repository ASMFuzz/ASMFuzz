import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11409 {

    static int buttonId = -517600826;

    static Frame frame = new Frame("MouseEvent Test Frame");

    static Point mousePosition = null;

    static Point mousePositionOnScreen = null;

    MouseEvent postMouseEventNewCtor(int buttonId) {
        MouseEvent me = new MouseEvent(frame, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), MouseEvent.BUTTON1_DOWN_MASK, mousePosition.x, mousePosition.y, mousePositionOnScreen.x, mousePositionOnScreen.y, 1, false, buttonId);
        frame.dispatchEvent((AWTEvent) me);
        return me;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11409().postMouseEventNewCtor(buttonId);
    }
}
