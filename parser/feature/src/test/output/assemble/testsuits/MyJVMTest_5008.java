import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5008 {

    static JTextField mainFrameTf2 = null;

    void verify() {
        Component c = DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (!(c == mainFrameTf2)) {
            throw new RuntimeException("Wrong focus owner.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5008().verify();
    }
}
