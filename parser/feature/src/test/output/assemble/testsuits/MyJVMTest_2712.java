import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2712 {

    static Object eParam1 = 0;

    static TreePath[] eParam2 = { null, null, null, null, null, null, null, null, null, null };

    static boolean[] eParam3 = { false, true, true, false, true, true, false, false, false, false };

    static Object[] eParam4Param1 = { 1, 6, 6, -1549073905, -83010601, 5, 2, 0, 109053107, 0 };

    static int eParam4Param2 = 621;

    static TreePath eParam4 = new TreePath(eParam4Param1, eParam4Param2);

    static TreePath eParam5 = new TreePath();

    static TreeSelectionEvent e = new TreeSelectionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean selectionChanged = false;

    TreeSelectionEvent valueChanged(TreeSelectionEvent e) {
        selectionChanged = true;
        System.out.println("selectionChanged");
        notifyAll();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2712().valueChanged(e);
    }
}
