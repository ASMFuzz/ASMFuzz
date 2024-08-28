import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6149 {

    static Component eParam1 = new Container();

    static int eParam2 = 557;

    static long eParam3 = 2970637094523631112L;

    static int eParam4 = 747;

    static int eParam5 = 724;

    static char eParam6 = '0';

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static int listenerCallCounter = 0;

    KeyEvent keyReleased(KeyEvent e) {
        listenerCallCounter++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6149().keyReleased(e);
    }
}
