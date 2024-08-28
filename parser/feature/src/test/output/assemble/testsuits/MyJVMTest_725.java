import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.Applet;

public class MyJVMTest_725 {

    static Component evtParam1 = new Container();

    static int evtParam2 = 499;

    static long evtParam3 = -7526963135886221227L;

    static int evtParam4 = 927;

    static int evtParam5 = 691;

    static char evtParam6 = Character.MIN_VALUE;

    static KeyEvent evt = new KeyEvent(evtParam1, evtParam2, evtParam3, evtParam4, evtParam5, evtParam6);

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
        new MyJVMTest_725().keyTyped(evt);
    }
}
