import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_14396 {

    static Object eParam1 = 0;

    static int eParam2 = 231;

    static String eParam3 = "dCN0+(4*68";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    static int listenerCallCounter = 0;

    ActionEvent actionPerformed(ActionEvent e) {
        listenerCallCounter++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14396().actionPerformed(e);
    }
}
