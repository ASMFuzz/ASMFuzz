import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.nimbus.*;

public class MyJVMTest_15135 {

    static E[] listParam1 = { null, null, null, null, null, null, null, null, null, null };

    static JList list = new JList(listParam1);

    Color testSelectionColors(JList list) {
        Color selBackColor = list.getSelectionBackground();
        if (!(selBackColor instanceof UIResource)) {
            throw new RuntimeException(String.format("JList.getSelectionBackground() returned instance of '%s' instead of UIResource.", selBackColor.getClass()));
        }
        Color selForeColor = list.getSelectionForeground();
        if (!(selForeColor instanceof UIResource)) {
            throw new RuntimeException(String.format("JList.getSelectionForeground() returned instance of '%s' instead of UIResource.", selForeColor.getClass()));
        }
        return selBackColor;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15135().testSelectionColors(list);
    }
}
