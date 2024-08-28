import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15319 {

    static Adjustable eParam1 = null;

    static int eParam2 = 189;

    static int eParam3 = 280;

    static int eParam4 = 640;

    static boolean eParam5 = false;

    static AdjustmentEvent e = new AdjustmentEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean do_test = false;

    static boolean passed = true;

    static JScrollBar sbar = null;

    void run() {
        final int oldValue = sbar.getValue();
        sbar.addAdjustmentListener(new AdjustmentListener() {

            public AdjustmentEvent adjustmentValueChanged(AdjustmentEvent e) {
                if (e.getValue() >= oldValue) {
                    passed = false;
                }
                do_test = true;
                return e;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15319().adjustmentValueChanged(e);
    }
}
