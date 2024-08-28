import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_5822 {

    static Object eParam1 = 3;

    static int eParam2 = 539;

    static String eParam3 = "gh.8F$[TxW";

    static ActionEvent e = new ActionEvent(eParam1, eParam2, eParam3);

    void jButton1_actionPerformed(ActionEvent e) {
        locale = ((JButton) e.getSource()).getInputContext().getLocale();
        System.out.println("locale" + n + ":" + locale.toString());
        bug4625203 frame2 = new bug4625203();
        frame2.n = n + 1;
        frame2.setSize(400, 300);
        frame2.setTitle("test:" + n);
        frame2.setVisible(true);
    }

    static JButton jButton1 = new JButton();

    static java.util.Locale locale = null;

    static int n = 0;

    ActionEvent actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5822().actionPerformed(e);
    }
}
