import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2834 {

    static Object aeParam1 = 0;

    static int aeParam2 = 924;

    static String aeParam3 = "2Hj/[O4Mv^";

    static long aeParam4 = 9223372036854775807L;

    static int aeParam5 = 764;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    ActionEvent actionPerformed(ActionEvent ae) {
        System.err.println(ae);
        throw new RuntimeException("Test failed - list is empty so event is redundant");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2834().actionPerformed(ae);
    }
}
