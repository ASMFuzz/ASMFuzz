import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_13566 {

    static Object eParam1 = -1341174574;

    static int eParam2 = 549;

    static String eParam3 = "h]0y|zKv%s";

    static int eParam4 = 804;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static Dialog d = new Dialog((Dialog) null, "NullParentDialog", true);

    static boolean actionPerformed = false;

    ActionEvent actionPerformed(ActionEvent e) {
        actionPerformed = true;
        System.out.println(e.paramString());
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13566().actionPerformed(e);
    }
}
