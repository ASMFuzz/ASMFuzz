import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_12125 {

    static Component eParam1 = new Container();

    static int eParam2 = 149;

    static long eParam3 = 0;

    static int eParam4 = 607;

    static int eParam5 = 152;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static int dispatchedEvents = -1619836507;

    KeyEvent keyReleased(KeyEvent e) {
        if (e.getKeyChar() == '1')
            dispatchedEvents++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12125().keyReleased(e);
    }
}
