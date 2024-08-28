import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_6681 {

    static Object aeParam1 = 0;

    static int aeParam2 = 777;

    static String aeParam3 = "|D rcQY@[)";

    static int aeParam4 = 591;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4);

    static Robot r = null;

    static boolean unblocked2 = true;

    ActionEvent actionPerformed(ActionEvent ae) {
        unblocked2 = true;
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6681().actionPerformed(ae);
    }
}
