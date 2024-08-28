import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_9903 {

    static Component evtParam1 = new Container();

    static int evtParam2 = 53;

    static long evtParam3 = -9223372036854775808L;

    static int evtParam4 = 18;

    static int evtParam5 = 819;

    static char evtParam6 = '0';

    static int evtParam7 = 867;

    static KeyEvent evt = new KeyEvent(evtParam1, evtParam2, evtParam3, evtParam4, evtParam5, evtParam6, evtParam7);

    void printKey(KeyEvent evt) {
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
    }

    static Hashtable<Character, Integer> keycharHash = new Hashtable<Character, Integer>();

    static boolean testFailed = false;

    char keyTyped(KeyEvent evt) {
        printKey(evt);
        char keych = evt.getKeyChar();
        if (!keycharHash.containsKey(keych)) {
            System.out.println("Unexpected keychar: " + keych);
            System.out.println("Unexpected keychar: " + keych);
            testFailed = true;
        }
        return keych;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9903().keyTyped(evt);
    }
}
