import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_10125 {

    static JTabbedPane tabbedPane = null;

    void run() {
        tabbedPane.requestFocus();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10125().run();
    }
}
