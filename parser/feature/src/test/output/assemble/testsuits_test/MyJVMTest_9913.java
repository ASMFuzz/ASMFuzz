import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9913 {

    static Component eParam1 = new Container();

    static int eParam2 = 888;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 232;

    static int eParam5 = 413;

    static char eParam6 = Character.MIN_VALUE;

    static int eParam7 = 948;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7);

    static boolean passed = false;

    KeyEvent keyPressed(KeyEvent e) {
        System.out.println("FocusSubRequestTest: keyPressed for: " + e.getSource());
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9913().keyPressed(e);
    }
}
