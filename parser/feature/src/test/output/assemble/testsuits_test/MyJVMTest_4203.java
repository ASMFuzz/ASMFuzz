import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_4203 {

    static Object eParam1 = 265269628;

    static int eParam2 = 436;

    static String eParam3 = "tN3qDF-#Sn";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static Dialog d = new Dialog((Dialog) null, "NullParentDialog", true);

    static boolean actionPerformed = false;

    ActionEvent actionPerformed(ActionEvent e) {
        actionPerformed = true;
        System.out.println(e.paramString());
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4203().actionPerformed(e);
    }
}
