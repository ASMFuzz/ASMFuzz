import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13522 {

    static Object rootParam1 = -793921178;

    static boolean rootParam2 = true;

    static DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootParam1, rootParam2);

    DefaultMutableTreeNode createNodes(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Node");
        node.add(new DefaultMutableTreeNode("Leaf1"));
        node.add(new DefaultMutableTreeNode("Leaf2"));
        root.add(node);
        root.add(new DefaultMutableTreeNode("Leaf3"));
        return node;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13522().createNodes(root);
    }
}
