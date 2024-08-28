import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11114 {

    static Component eParam1 = new Container();

    static int eParam2 = 245;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 888;

    static int eParam5 = 29;

    static char eParam6 = Character.MAX_VALUE;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static int listenerCallCounter = 0;

    KeyEvent keyPressed(KeyEvent e) {
        listenerCallCounter++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11114().keyPressed(e);
    }
}
