import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16302 {

    static JFrame frame = null;

    void run() {
        frame.setExtendedState(Frame.ICONIFIED);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16302().run();
    }
}
