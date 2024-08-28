import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import sun.awt.*;

public class MyJVMTest_12526 {

    void startGUI() {
        tf.requestFocusInWindow();
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Timer tick: " + timerValue++);
            }
        };
        new javax.swing.Timer(30, al).start();
    }

    void actionPerformed(ActionEvent ae) {
        System.out.println("Timer tick: " + timerValue++);
    }

    static JFrame f = null;

    static JTextField tf = null;

    static int timerValue = 0;

    void run() {
        startGUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12526().run();
    }
}
