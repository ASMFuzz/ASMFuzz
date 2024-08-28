import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_8640 {

    static boolean flag = false;

    static boolean defaultButtonPressed = false;

    boolean testDefaultButton(boolean flag) {
        if (defaultButtonPressed != flag) {
            new RuntimeException("defaultButtonPressed unexpectedly = " + defaultButtonPressed);
        }
        defaultButtonPressed = false;
        return flag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8640().testDefaultButton(flag);
    }
}
