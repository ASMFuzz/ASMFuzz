import java.awt.*;
import sun.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class MyJVMTest_9090 {

    static Object eParam1 = 0;

    static int eParam2 = 512;

    static String eParam3 = "gb8d2{cdZB";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static Window parent = null;

    static int width = 468705244, height = 0;

    ActionEvent actionPerformed(ActionEvent e) {
        parent.dispose();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9090().actionPerformed(e);
    }
}
