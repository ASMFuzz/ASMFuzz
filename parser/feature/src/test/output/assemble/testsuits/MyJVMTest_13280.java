import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_13280 {

    static JFrame frame = null;

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    void run() {
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13280().run();
    }
}
