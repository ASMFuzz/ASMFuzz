import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6722 {

    static JTree tree = null;

    void run() {
        tree.requestFocus();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6722().run();
    }
}
