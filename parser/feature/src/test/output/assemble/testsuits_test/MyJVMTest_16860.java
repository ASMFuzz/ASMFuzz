import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MyJVMTest_16860 {

    static Object eParam1 = -1319763974;

    static int eParam2 = 776;

    static String eParam3 = "_Q*o;qngL$";

    static int eParam4 = 231;

    static AWTEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

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
        new MyJVMTest_16860().eventDispatched(e);
    }
}
