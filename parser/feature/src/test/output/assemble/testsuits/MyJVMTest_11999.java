import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11999 {

    static Object eParam1 = 0;

    static TreePath[] eParam2 = { null, null, null, null, null, null, null, null, null, null };

    static boolean[] eParam3 = { false, false, true, true, false, false, true, true, true, true };

    static TreePath eParam4 = new TreePath();

    static TreePath eParam5Param1 = new TreePath();

    static Object eParam5Param2 = 0;

    static TreePath eParam5 = new TreePath(eParam5Param1, eParam5Param2);

    static TreeSelectionEvent e = new TreeSelectionEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean selectionChanged = false;

    TreeSelectionEvent valueChanged(TreeSelectionEvent e) {
        selectionChanged = true;
        System.out.println("selectionChanged");
        notifyAll();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11999().valueChanged(e);
    }
}
