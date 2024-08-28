import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15619 {

    static Component eParam1 = new Container();

    static int eParam2 = 372;

    static long eParam3 = -940739378340894094L;

    static int eParam4 = 510;

    static int eParam5 = 291;

    static char eParam6 = '\\';

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static int listenerCallCounter = 0;

    KeyEvent keyReleased(KeyEvent e) {
        listenerCallCounter++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15619().keyReleased(e);
    }
}
