import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_14536 {

    static Object aeParam1 = 6;

    static int aeParam2 = 536;

    static String aeParam3 = "S8k`=O=Yp-";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    static List list = new List(8, false);

    ActionEvent actionPerformed(ActionEvent ae) {
        list.setMultipleMode(true);
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14536().actionPerformed(ae);
    }
}
