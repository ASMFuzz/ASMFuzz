import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16386 {

    static JFrame frame = null;

    static JLayeredPane lPane = null;

    void run() {
        lPane = frame.getLayeredPane();
        System.out.println("JFrame's LayeredPane " + lPane);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16386().run();
    }
}
