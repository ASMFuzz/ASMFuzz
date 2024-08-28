import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14938 {

    static Object eParam1 = 9;

    static int eParam2 = 722;

    static String eParam3 = "FF!et14*5@";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static boolean buttonPressed = false;

    ActionEvent actionPerformed(ActionEvent e) {
        System.out.println("Test PASSED");
        buttonPressed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14938().actionPerformed(e);
    }
}
