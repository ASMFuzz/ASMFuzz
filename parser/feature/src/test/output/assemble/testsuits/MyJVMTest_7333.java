import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyJVMTest_7333 {

    static Object eParam1 = 0;

    static int eParam2 = 92;

    static String eParam3 = "cuXED^6'd8";

    static long eParam4 = 9223372036854775807L;

    static int eParam5 = 537;

    static AWTEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static Object SYNC_LOCK = new Object();

    static Util theInstance = new Util();

    static Component clickedComponent = null;

    AWTEvent eventDispatched(AWTEvent e) {
        if (e.getID() == MouseEvent.MOUSE_RELEASED) {
            clickedComponent = (Component) e.getSource();
            synchronized (SYNC_LOCK) {
                SYNC_LOCK.notifyAll();
            }
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7333().eventDispatched(e);
    }
}
