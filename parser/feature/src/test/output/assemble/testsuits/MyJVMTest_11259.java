import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11259 {

    static Object eParam1 = 4;

    static TreePath eParam2 = new TreePath();

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
        new MyJVMTest_11259().treeCollapsed(e);
    }
}
