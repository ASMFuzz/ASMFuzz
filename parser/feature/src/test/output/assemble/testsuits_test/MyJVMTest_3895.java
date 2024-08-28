import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3895 {

    void createNodes(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Node");
        node.add(new DefaultMutableTreeNode("Leaf1"));
        node.add(new DefaultMutableTreeNode("Leaf2"));
        root.add(node);
        root.add(new DefaultMutableTreeNode("Leaf3"));
    }

    static Object listener = new bug4927934();

    static JFrame frame = null;

    static JTree tree = null;

    void run() {
        frame = new JFrame();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        createNodes(root);
        tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree);
        frame.getContentPane().add(scrollPane);
        tree.addFocusListener((FocusListener) listener);
        tree.addTreeSelectionListener((TreeSelectionListener) listener);
        tree.addTreeExpansionListener((TreeExpansionListener) listener);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3895().run();
    }
}
