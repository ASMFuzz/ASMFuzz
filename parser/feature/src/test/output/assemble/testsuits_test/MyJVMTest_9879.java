import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_9879 {

    static Object aeParam1 = 9;

    static int aeParam2 = 879;

    static String aeParam3 = "x}!<Eiu?vl";

    static long aeParam4 = 0;

    static int aeParam5 = 465;

    static ActionEvent ae = new ActionEvent(aeParam1, aeParam2, aeParam3, aeParam4, aeParam5);

    static List list = new List(8, false);

    ActionEvent actionPerformed(ActionEvent ae) {
        list.setFont(new Font("SansSerif", Font.PLAIN, 30));
        list.repaint();
        return ae;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9879().actionPerformed(ae);
    }
}
