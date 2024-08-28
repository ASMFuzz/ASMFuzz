import java.awt.AWTKeyStroke;
import java.awt.event.InputEvent;

public class MyJVMTest_4832 {

    static char awtKeyStrokeParam1 = Character.MIN_VALUE;

    static int awtKeyStrokeParam2 = 98;

    static int awtKeyStrokeParam3 = 943;

    static boolean awtKeyStrokeParam4 = false;

    static AWTKeyStroke awtKeyStroke = new AWTKeyStroke(awtKeyStrokeParam1, awtKeyStrokeParam2, awtKeyStrokeParam3, awtKeyStrokeParam4);

    static int keyCode = 4;

    static int modifiers = 1;

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
        new MyJVMTest_4832().checkAWTKeyStroke(awtKeyStroke, keyCode, modifiers, onKeyRelease);
    }
}
