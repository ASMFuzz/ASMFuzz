import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyJVMTest_13598 {

    static ItemSelectable ieParam1 = null;

    static int ieParam2 = 32;

    static Object ieParam3 = 0;

    static int ieParam4 = 648;

    static ItemEvent ie = new ItemEvent(ieParam1, ieParam2, ieParam3, ieParam4);

    static List list = new ArrayList();

    ItemEvent itemStateChanged(ItemEvent ie) {
        System.err.println(ie);
        throw new RuntimeException("Test failed - list is empty so event is redundant");
        return ie;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13598().itemStateChanged(ie);
    }
}
