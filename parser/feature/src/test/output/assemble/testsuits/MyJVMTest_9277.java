import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9277 {

    static Component eParam1 = new Container();

    static int eParam2 = 412;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 84;

    static int eParam5 = 70;

    static int eParam6 = 593;

    static int eParam7 = 449;

    static boolean eParam8 = false;

    static int eParam9 = 904;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static JTabbedPane tabPane = null;

    static JPanel mainPanel = null;

    static int placement = 0;

    static boolean a = true;

    Point mouseClicked(MouseEvent e) {
        Point pt = e.getPoint();
        System.out.println("Index at location: " + tabPane.indexAtLocation(pt.x, pt.y));
        return pt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9277().mouseClicked(e);
    }
}
