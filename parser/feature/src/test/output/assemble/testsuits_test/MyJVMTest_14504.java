import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_14504 {

    static Component evtParam1 = new Container();

    static int evtParam2 = 949;

    static long evtParam3 = 1685867064815213057L;

    static int evtParam4 = 600;

    static int evtParam5 = 434;

    static KeyEvent evt = new KeyEvent(evtParam1, evtParam2, evtParam3, evtParam4, evtParam5);

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
        new MyJVMTest_14504().printKey(evt);
    }
}
