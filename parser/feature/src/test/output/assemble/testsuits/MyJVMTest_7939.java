import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7939 {

    static Object listener = new bug4927934();

    static boolean treeExpanded = false;

    static JTree tree = null;

    boolean isTreeExpanded() {
        synchronized (listener) {
            if (!treeExpanded) {
                System.out.println("waiting for treeExpanded...");
                try {
                    listener.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return treeExpanded;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7939().isTreeExpanded());
    }
}
