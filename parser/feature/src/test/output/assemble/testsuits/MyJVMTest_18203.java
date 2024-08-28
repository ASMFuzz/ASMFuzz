import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyJVMTest_18203 {

    static Object pickParam1 = 0;

    static ChangeEvent pick = new ChangeEvent(pickParam1);

    static JTabbedPane tabbedPane = null;

    static boolean bStateChanged = false;

    ChangeEvent stateChanged(final ChangeEvent pick) {
        bStateChanged = true;
        if (tabbedPane.getTabCount() == 3) {
            tabbedPane.remove(2);
        }
        return pick;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18203().stateChanged(pick);
    }
}
