import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_18158 {

    static int seconds = 7;

    static JFrame frame = null;

    static JDialog dialog = null;

    static int sleepTime = 300000;

    int setTimeoutTo(int seconds) {
        sleepTime = seconds * 1000;
        return seconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18158().setTimeoutTo(seconds);
    }
}
