import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13487 {

    static Component eParam1 = new Container();

    static int eParam2 = 251;

    static long eParam3 = 0;

    static int eParam4 = 279;

    static int eParam5 = 981;

    static int eParam6 = 519;

    static int eParam7 = 405;

    static boolean eParam8 = false;

    static int eParam9 = 993;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int lastClickCount = 0;

    static boolean clicked = false;

    MouseEvent mouseClicked(MouseEvent e) {
        System.out.println(e.toString());
        clicked = true;
        lastClickCount = e.getClickCount();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13487().mouseClicked(e);
    }
}
