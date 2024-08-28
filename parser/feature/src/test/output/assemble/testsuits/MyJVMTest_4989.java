import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_4989 {

    static Object eParam1 = 9;

    static int eParam2 = 111;

    static String eParam3 = ",eON$*)m\\h";

    static int eParam4 = 805;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static int listenerCallCounter = 0;

    ActionEvent actionPerformed(ActionEvent e) {
        listenerCallCounter++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4989().actionPerformed(e);
    }
}
