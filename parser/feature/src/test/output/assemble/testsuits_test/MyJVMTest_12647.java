import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyJVMTest_12647 {

    static JTabbedPane tabbedPane = null;

    static Rectangle bounds = null;

    void run() {
        bounds = tabbedPane.getUI().getTabBounds(tabbedPane, 0);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12647().run();
    }
}
