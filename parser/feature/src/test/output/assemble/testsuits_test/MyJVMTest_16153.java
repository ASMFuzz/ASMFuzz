import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16153 {

    static Object eParam1 = 1;

    static TreePath eParam2 = new TreePath();

    static TreeExpansionEvent e = new TreeExpansionEvent(eParam1, eParam2);

    static boolean treeExpanded = false;

    static JTree tree = null;

    TreeExpansionEvent treeExpanded(TreeExpansionEvent e) {
        System.out.println("treeExpanded");
        treeExpanded = true;
        notifyAll();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16153().treeExpanded(e);
    }
}
