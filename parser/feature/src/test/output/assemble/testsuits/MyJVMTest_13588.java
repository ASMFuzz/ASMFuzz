import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import sun.awt.*;

public class MyJVMTest_13588 {

    static Object aeParam1 = 7;

    static int aeParam2 = 559;

    static String aeParam3 = "bt|N=E}L:,";

    static long aeParam4 = 0;

    static int aeParam5 = 872;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static JFrame f = null;

    static JTextField tf = null;

    static int timerValue = 0;

    void startGUI() {
        tf.requestFocusInWindow();
        ActionListener al = new ActionListener() {

            @Override
            public ActionEvent actionPerformed(ActionEvent ae) {
                System.out.println("Timer tick: " + timerValue++);
                return ae;
            }
        };
        new javax.swing.Timer(30, al).start();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13588().actionPerformed(ae);
    }
}
