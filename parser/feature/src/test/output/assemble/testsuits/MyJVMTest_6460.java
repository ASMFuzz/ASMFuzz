import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_6460 {

    static JFrame frame = null;

    void run() {
        frame.setBounds(100, 100, 200, 300);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6460().run();
    }
}
