import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_15175 {

    static JFrame frame = null;

    void run() {
        frame.setBounds(100, 100, 800, 800);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15175().run();
    }
}
