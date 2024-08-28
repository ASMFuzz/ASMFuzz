import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_17198 {

    static Component evtParam1 = new Container();

    static int evtParam2 = 382;

    static long evtParam3 = -119543313690030295L;

    static int evtParam4 = 40;

    static int evtParam5 = 482;

    static KeyEvent evt = new KeyEvent(evtParam1, evtParam2, evtParam3, evtParam4, evtParam5);

    KeyEvent printKey(KeyEvent evt) {
        switch(evt.getID()) {
            case KeyEvent.KEY_TYPED:
            case KeyEvent.KEY_PRESSED:
            case KeyEvent.KEY_RELEASED:
                break;
            default:
                System.out.println("Other Event ");
                Sysout.println("Other Event ");
                return;
        }
        System.out.print(" 0x" + Integer.toHexString(evt.getKeyChar()));
        Sysout.println(" 0x" + Integer.toHexString(evt.getKeyChar()));
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17198().printKey(evt);
    }
}
