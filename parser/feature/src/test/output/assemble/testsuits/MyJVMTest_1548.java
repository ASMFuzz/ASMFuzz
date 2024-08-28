import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_1548 {

    static Component eParam1 = new Container();

    static int eParam2 = 983;

    static long eParam3 = 0;

    static int eParam4 = 226;

    static int eParam5 = 462;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static int dispatchedEvents = 4;

    KeyEvent keyPressed(KeyEvent e) {
        if (e.getKeyChar() == '1')
            dispatchedEvents++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1548().keyPressed(e);
    }
}
