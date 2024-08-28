import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_13088 {

    static Object aeParam1 = 1;

    static int aeParam2 = 0;

    static String aeParam3 = "UVH^-$/M@t";

    static long aeParam4 = 9223372036854775807L;

    static int aeParam5 = 59;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static Robot r = null;

    static boolean unblocked1 = true;

    ActionEvent actionPerformed(ActionEvent ae) {
        unblocked1 = true;
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13088().actionPerformed(ae);
    }
}
