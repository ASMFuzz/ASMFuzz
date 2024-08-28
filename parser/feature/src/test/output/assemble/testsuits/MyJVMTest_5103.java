import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_5103 {

    static Object aeParam1 = 667355500;

    static int aeParam2 = 582;

    static String aeParam3 = "oWhww~zk{D";

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3);

    static Robot r = null;

    static JDesktopPane pane1 = null;

    static JDesktopPane pane2 = null;

    static JFrame frame1 = null;

    static JFrame frame2 = null;

    static JButton bn1 = null;

    static JButton bs1 = null;

    static JButton bn2 = null;

    static JButton bs2 = null;

    static boolean unblocked1 = true;

    static boolean unblocked2 = true;

    void init() {
        pane1 = new JDesktopPane();
        pane2 = new JDesktopPane();
        frame1 = new JFrame("F1");
        frame1.setBounds(100, 100, 320, 240);
        frame1.getContentPane().setLayout(new BorderLayout());
        frame1.getContentPane().add(pane1);
        bn1 = new JButton("Test");
        bn1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                unblocked1 = true;
            }
        });
        frame1.getContentPane().add(bn1, BorderLayout.NORTH);
        bs1 = new JButton("Show dialog");
        bs1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showInternalMessageDialog(pane1, "Dialog1");
            }
        });
        frame1.getContentPane().add(bs1, BorderLayout.SOUTH);
        frame2 = new JFrame("F2");
        frame2.setBounds(100, 400, 320, 240);
        frame2.getContentPane().setLayout(new BorderLayout());
        frame2.getContentPane().add(pane2);
        bn2 = new JButton("Test");
        bn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                unblocked2 = true;
            }
        });
        frame2.getContentPane().add(bn2, BorderLayout.NORTH);
        bs2 = new JButton("Show dialog");
        bs2.addActionListener(new ActionListener() {

            public ActionEvent actionPerformed(ActionEvent ae) {
                JOptionPane.showInternalMessageDialog(pane2, "Dialog2");
                return ae;
            }
        });
        frame2.getContentPane().add(bs2, BorderLayout.SOUTH);
        frame1.setVisible(true);
        frame2.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5103().actionPerformed(ae);
    }
}
