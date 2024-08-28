import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_10768 {

    static Component eParam1 = new Container();

    static int eParam2 = 138;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 607;

    static int eParam5 = 204;

    static char eParam6 = 'K';

    static int eParam7 = 60;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7);

    static int dispatchedEvents = -1396369119;

    KeyEvent keyPressed(KeyEvent e) {
        if (e.getKeyChar() == '1')
            dispatchedEvents++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10768().keyPressed(e);
    }
}
