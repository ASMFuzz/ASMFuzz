import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7788 {

    static ItemSelectable ieParam1 = null;

    static int ieParam2 = 495;

    static Object ieParam3 = 1003822342;

    static int ieParam4 = 641;

    static ItemEvent ie = new ItemEvent(ieParam1, ieParam2, ieParam3, ieParam4);

    ItemEvent itemStateChanged(ItemEvent ie) {
        System.err.println(ie);
        throw new RuntimeException("Test failed - list is empty so event is redundant");
        return ie;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7788().itemStateChanged(ie);
    }
}
