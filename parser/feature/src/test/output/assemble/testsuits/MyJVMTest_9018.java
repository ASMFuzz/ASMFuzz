import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9018 {

    static ItemSelectable ieParam1 = null;

    static int ieParam2 = 771;

    static Object ieParam3 = 1166560765;

    static int ieParam4 = 156;

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
        new MyJVMTest_9018().itemStateChanged(ie);
    }
}
