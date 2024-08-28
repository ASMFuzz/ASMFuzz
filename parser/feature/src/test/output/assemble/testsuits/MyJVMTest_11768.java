import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_11768 {

    static Point framePosition = null;

    static JFrame frame = null;

    void run() {
        framePosition = frame.getLocationOnScreen();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11768().run();
    }
}
