import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16177 {

    static Object aeParam1 = 2088407011;

    static int aeParam2 = 441;

    static String aeParam3 = "[90!*[r2+1";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    static Robot r = null;

    static boolean unblocked2 = true;

    ActionEvent actionPerformed(ActionEvent ae) {
        unblocked2 = true;
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16177().actionPerformed(ae);
    }
}
