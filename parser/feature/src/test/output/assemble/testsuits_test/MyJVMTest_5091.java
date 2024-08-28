import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_5091 {

    static Component evtParam1 = new Container();

    static int evtParam2 = 750;

    static long evtParam3 = -3277264529115249860L;

    static int evtParam4 = 823;

    static int evtParam5 = 455;

    static char evtParam6 = Character.MAX_VALUE;

    static int evtParam7 = 358;

    static KeyEvent evt = new KeyEvent(evtParam1, evtParam2, evtParam3, evtParam4, evtParam5, evtParam6, evtParam7);

    KeyEvent printKey(KeyEvent evt) {
        switch(evt.getID()) {
            case KeyEvent.KEY_TYPED:
            case KeyEvent.KEY_PRESSED:
            case KeyEvent.KEY_RELEASED:
                break;
            default:
                System.out.println("Other Event ");
                System.out.println("Other Event ");
                return;
        }
        System.out.print(" 0x" + Integer.toHexString(evt.getKeyChar()));
        System.out.println(" 0x" + Integer.toHexString(evt.getKeyChar()));
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5091().printKey(evt);
    }
}
