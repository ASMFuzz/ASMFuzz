import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11097 {

    void verify() {
        Component c = DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (!(c == mainFrameTf2)) {
            throw new RuntimeException("Wrong focus owner.");
        }
    }

    static JTextField mainFrameTf2 = null;

    void run() {
        verify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11097().run();
    }
}
