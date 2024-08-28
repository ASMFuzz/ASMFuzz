import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyJVMTest_4704 {

    static Object aeParam1 = 9;

    static int aeParam2 = 668;

    static String aeParam3 = "*[Y-%uU!8g";

    static long aeParam4 = -9223372036854775808L;

    static int aeParam5 = 168;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static List list = new ArrayList();

    ActionEvent actionPerformed(ActionEvent ae) {
        System.err.println(ae);
        throw new RuntimeException("Test failed - list is empty so event is redundant");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4704().actionPerformed(ae);
    }
}
