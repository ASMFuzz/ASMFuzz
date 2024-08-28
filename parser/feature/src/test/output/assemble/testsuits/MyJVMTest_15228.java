import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_15228 {

    static Component evtParam1 = new Container();

    static int evtParam2 = 87;

    static long evtParam3 = -9223372036854775808L;

    static int evtParam4 = 143;

    static int evtParam5 = 145;

    static KeyEvent evt = new KeyEvent(evtParam1, evtParam2, evtParam3, evtParam4, evtParam5);

    void printKey(KeyEvent evt) {
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
    }

    static Hashtable<Character, Integer> keycharHash = new Hashtable<Character, Integer>();

    static boolean testFailed = false;

    char keyTyped(KeyEvent evt) {
        printKey(evt);
        char keych = evt.getKeyChar();
        if (!keycharHash.containsKey(keych)) {
            System.out.println("Unexpected keychar: " + keych);
            Sysout.println("Unexpected keychar: " + keych);
            testFailed = true;
        }
        return keych;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15228().keyTyped(evt);
    }
}
