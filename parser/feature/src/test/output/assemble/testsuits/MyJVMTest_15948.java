import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_15948 {

    static JFrame frame = null;

    void run() {
        frame.setBounds(100, 100, 200, 300);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15948().run();
    }
}
