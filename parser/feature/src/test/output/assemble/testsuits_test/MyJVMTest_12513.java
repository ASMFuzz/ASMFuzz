import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_12513 {

    static Object eParam1 = 9;

    static int eParam2 = 119;

    static String eParam3 = "N')$aq _.w";

    static long eParam4 = 9223372036854775807L;

    static int eParam5 = 819;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static Dialog d = new Dialog((Dialog) null, "NullParentDialog", true);

    static boolean actionPerformed = false;

    ActionEvent actionPerformed(ActionEvent e) {
        actionPerformed = true;
        Sysout.println(e.paramString());
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12513().actionPerformed(e);
    }
}
