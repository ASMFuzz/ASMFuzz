import java.awt.AWTKeyStroke;
import java.awt.event.InputEvent;

public class MyJVMTest_14232 {

    static AWTKeyStroke awtKeyStroke = new AWTKeyStroke();

    static int keyCode = 0;

    static int modifiers = 0;

    static boolean onKeyRelease = false;

    AWTKeyStroke checkAWTKeyStroke(AWTKeyStroke awtKeyStroke, int keyCode, int modifiers, boolean onKeyRelease) {
        if (awtKeyStroke.getKeyCode() != keyCode) {
            throw new RuntimeException("Wrong key code!");
        }
        if (awtKeyStroke.getModifiers() != modifiers) {
            throw new RuntimeException("Wrong modifiers!");
        }
        if (awtKeyStroke.isOnKeyRelease() != onKeyRelease) {
            throw new RuntimeException("Wrong on key release!");
        }
        return awtKeyStroke;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14232().checkAWTKeyStroke(awtKeyStroke, keyCode, modifiers, onKeyRelease);
    }
}
