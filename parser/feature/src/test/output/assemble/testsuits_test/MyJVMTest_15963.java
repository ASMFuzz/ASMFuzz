import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15963 {

    static ItemSelectable ieParam1 = null;

    static int ieParam2 = 980;

    static Object ieParam3 = 2;

    static int ieParam4 = 612;

    static ItemEvent ie = new ItemEvent(ieParam1, ieParam2, ieParam3, ieParam4);

    static Robot robot = null;

    static Toolkit tk = Toolkit.getDefaultToolkit();

    static Choice choice = new Choice();

    static boolean indexChanged = false;

    static int INITIAL_ITEM = 99;

    static boolean stateChanged = true;

    ItemEvent itemStateChanged(ItemEvent ie) {
        System.out.println("choice.stateChanged = " + ie);
        stateChanged = true;
        return ie;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15963().itemStateChanged(ie);
    }
}
