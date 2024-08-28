import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_2829 {

    static Component eParam1 = new Container();

    static int eParam2 = 185;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 6;

    static int eParam5 = 986;

    static char eParam6 = Character.MAX_VALUE;

    static int eParam7 = 296;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7);

    static int dispatchedEvents = 1902902560;

    KeyEvent keyReleased(KeyEvent e) {
        if (e.getKeyChar() == '1')
            dispatchedEvents++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2829().keyReleased(e);
    }
}
