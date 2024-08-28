import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyJVMTest_14101 {

    static Object aeParam1 = 0;

    static int aeParam2 = 984;

    static String aeParam3 = "~z+'[saCVI";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    static List list = new ArrayList();

    ActionEvent actionPerformed(ActionEvent ae) {
        System.err.println(ae);
        throw new RuntimeException("Test failed - list is empty so event is redundant");
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14101().actionPerformed(ae);
    }
}
