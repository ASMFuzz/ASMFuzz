import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4126 {

    static Component eParam1 = new Container();

    static int eParam2 = 196;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 451;

    static int eParam5 = 214;

    static int eParam6 = 335;

    static int eParam7 = 266;

    static boolean eParam8 = true;

    static int eParam9 = 387;

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
        new MyJVMTest_4126().mouseClicked(e);
    }
}
