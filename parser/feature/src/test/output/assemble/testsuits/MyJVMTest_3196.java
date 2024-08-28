import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_3196 {

    static Object eParam1 = 0;

    static int eParam2 = 315;

    static String eParam3 = "ZsUS{p<o*,";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static Dialog d = new Dialog((Dialog) null, "NullParentDialog", true);

    static boolean actionPerformed = false;

    ActionEvent actionPerformed(ActionEvent e) {
        actionPerformed = true;
        Sysout.println(e.paramString());
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3196().actionPerformed(e);
    }
}
