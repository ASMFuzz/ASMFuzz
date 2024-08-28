import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_3749 {

    static Object aeParam1 = 0;

    static int aeParam2 = 910;

    static String aeParam3 = "8.ca?/|v/<";

    static long aeParam4 = -9223372036854775808L;

    static int aeParam5 = 892;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static Robot r = null;

    static boolean unblocked1 = true;

    ActionEvent actionPerformed(ActionEvent ae) {
        unblocked1 = true;
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3749().actionPerformed(ae);
    }
}
