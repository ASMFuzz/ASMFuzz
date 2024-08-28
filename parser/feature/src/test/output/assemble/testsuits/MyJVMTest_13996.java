import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13996 {

    static int shouldBeSel = -1895715716;

    static Object listener = new bug4927934();

    static boolean selectionChanged = false;

    static JTree tree = null;

    boolean checkSelectionChanged(JTree tree, int shouldBeSel) {
        synchronized (listener) {
            if (!selectionChanged) {
                System.out.println("waiting for selectionChanged...");
                try {
                    listener.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        int selRow = tree.getLeadSelectionRow();
        System.out.println("Selected row: " + selRow);
        return selRow == shouldBeSel;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13996().checkSelectionChanged(tree, shouldBeSel));
    }
}
