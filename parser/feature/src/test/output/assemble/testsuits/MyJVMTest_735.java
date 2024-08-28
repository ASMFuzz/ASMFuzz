import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_735 {

    static Component eParam1 = new Container();

    static int eParam2 = 515;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 119;

    static int eParam5 = 409;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean passed = false;

    KeyEvent keyPressed(KeyEvent e) {
        System.out.println("FocusSubRequestTest: keyPressed for: " + e.getSource());
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_735().keyPressed(e);
    }
}
