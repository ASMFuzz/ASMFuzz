import java.awt.*;
import java.awt.print.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class MyJVMTest_16532 {

    static Object eParam1 = 2;

    static int eParam2 = 174;

    static String eParam3 = "*73L]e|eNY";

    static AWTEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    AWTEvent eventDispatched(AWTEvent e) {
        if (e.getSource().getClass() == TestFrame.class) {
            Sysout.println(e.paramString() + " on <Test Frame>");
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16532().eventDispatched(e);
    }
}
