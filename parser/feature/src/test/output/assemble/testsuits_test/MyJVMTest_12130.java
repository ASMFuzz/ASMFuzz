import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12130 {

    static Object aeParam1 = 2;

    static int aeParam2 = 598;

    static String aeParam3 = "*-ER(d\\4j ";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    ActionEvent actionPerformed(ActionEvent ae) {
        System.err.println(ae);
        throw new RuntimeException("Test failed - list is empty so event is redundant");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12130().actionPerformed(ae);
    }
}
