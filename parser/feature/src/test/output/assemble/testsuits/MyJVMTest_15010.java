import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_15010 {

    static boolean flag = true;

    static boolean defaultButtonPressed = false;

    boolean testDefaultButton(boolean flag) {
        if (defaultButtonPressed != flag) {
            new RuntimeException("defaultButtonPressed unexpectedly = " + defaultButtonPressed);
        }
        defaultButtonPressed = false;
        return flag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15010().testDefaultButton(flag);
    }
}
