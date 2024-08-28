import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5507 {

    static Object eParam1 = 0;

    static int eParam2 = 759;

    static String eParam3 = "(T[gyk~@\"8";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static boolean buttonPressed = false;

    ActionEvent actionPerformed(ActionEvent e) {
        System.out.println("Test PASSED");
        buttonPressed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5507().actionPerformed(e);
    }
}
