import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4161 {

    static DefaultMutableTreeNode root = new DefaultMutableTreeNode();

    DefaultMutableTreeNode createNodes(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("Node");
        node.add(new DefaultMutableTreeNode("Leaf1"));
        node.add(new DefaultMutableTreeNode("Leaf2"));
        root.add(node);
        root.add(new DefaultMutableTreeNode("Leaf3"));
        return node;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4161().createNodes(root);
    }
}
