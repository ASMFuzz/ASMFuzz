import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_2318 {

    static Object eParam1 = 0;

    static int eParam2 = 440;

    static String eParam3 = "9~r>#!%k/e";

    static int eParam4 = 65;

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3, eParam4);

    static JButton jButton1 = new JButton();

    static java.util.Locale locale = null;

    static int n = 0;

    bug4625203 jButton1_actionPerformed(ActionEvent e) {
        locale = ((JButton) e.getSource()).getInputContext().getLocale();
        System.out.println("locale" + n + ":" + locale.toString());
        bug4625203 frame2 = new bug4625203();
        frame2.n = n + 1;
        frame2.setSize(400, 300);
        frame2.setTitle("test:" + n);
        frame2.setVisible(true);
        return frame2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2318().jButton1_actionPerformed(e);
    }
}
