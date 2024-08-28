import java.awt.*;
import java.awt.print.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class MyJVMTest_7017 {

    static Object eParam1 = 2;

    static int eParam2 = 700;

    static String eParam3 = "uA?/WC30iX";

    static AWTEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    AWTEvent eventDispatched(AWTEvent e) {
        if (e.getSource().getClass() == TestFrame.class) {
            Sysout.println(e.paramString() + " on <Test Frame>");
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7017().eventDispatched(e);
    }
}
