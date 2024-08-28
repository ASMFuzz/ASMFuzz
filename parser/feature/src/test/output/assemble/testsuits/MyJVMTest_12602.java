import java.awt.*;
import sun.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class MyJVMTest_12602 {

    static Object eParam1 = 3;

    static int eParam2 = 154;

    static String eParam3 = "J^Zr2vZM7S";

    static long eParam4 = 9223372036854775807L;

    static int eParam5 = 602;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static Window parent = null;

    static int width = 266924276, height = 1509011056;

    ActionEvent actionPerformed(ActionEvent e) {
        parent.dispose();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12602().actionPerformed(e);
    }
}
