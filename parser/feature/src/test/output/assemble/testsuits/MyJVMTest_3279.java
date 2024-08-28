import java.awt.*;
import sun.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class MyJVMTest_3279 {

    static Object eParam1 = 1;

    static int eParam2 = 628;

    static String eParam3 = "0%e^S&P1|B";

    static long eParam4 = 9223372036854775807L;

    static int eParam5 = 873;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static Window parent = null;

    static int width = 0, height = 4;

    ActionEvent actionPerformed(ActionEvent e) {
        parent.dispose();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3279().actionPerformed(e);
    }
}
