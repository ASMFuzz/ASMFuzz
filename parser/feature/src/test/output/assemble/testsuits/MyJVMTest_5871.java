import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5871 {

    static Adjustable eParam1 = null;

    static int eParam2 = 684;

    static int eParam3 = 820;

    static int eParam4 = 314;

    static AdjustmentEvent e = new AdjustmentEvent(eParam1, eParam2, eParam3, eParam4);

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
        new MyJVMTest_5871().adjustmentValueChanged(e);
    }
}
