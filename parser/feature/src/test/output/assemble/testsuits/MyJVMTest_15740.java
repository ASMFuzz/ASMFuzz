import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MyJVMTest_15740 {

    static JTree tree = null;

    void run() {
        tree.startEditingAtPath(tree.getPathForRow(0));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15740().run();
    }
}
