import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1884 {

    static Component eParam1 = new Container();

    static int eParam2 = 740;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 193;

    static int eParam5 = 881;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static int listenerCallCounter = 0;

    KeyEvent keyPressed(KeyEvent e) {
        listenerCallCounter++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1884().keyPressed(e);
    }
}
