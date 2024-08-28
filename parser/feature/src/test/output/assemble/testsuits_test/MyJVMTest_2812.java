import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2812 {

    static Object listener = new bug4927934();

    static boolean treeCollapsed = false;

    static JTree tree = null;

    boolean isTreeCollapsed() {
        synchronized (listener) {
            if (!treeCollapsed) {
                System.out.println("waiting for treeCollapsed...");
                try {
                    listener.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return treeCollapsed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2812().isTreeCollapsed());
    }
}
