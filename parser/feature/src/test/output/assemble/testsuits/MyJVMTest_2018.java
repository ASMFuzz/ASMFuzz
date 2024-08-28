import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2018 {

    static Object eParam1 = 7;

    static Object[] eParam2Param1 = { 5, 0, -1950683143, 7, 1431838227, 5, 2, 0, 0, 2 };

    static int eParam2Param2 = 679;

    static TreePath eParam2 = new TreePath(eParam2Param1, eParam2Param2);

    static TreeExpansionEvent e = new TreeExpansionEvent(eParam1, eParam2);

    static boolean treeCollapsed = false;

    static JTree tree = null;

    TreeExpansionEvent treeCollapsed(TreeExpansionEvent e) {
        System.out.println("treeCollapsed");
        treeCollapsed = true;
        notifyAll();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2018().treeCollapsed(e);
    }
}
