import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12900 {

    static Component eParam1 = new Container();

    static int eParam2 = 165;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 9;

    static int eParam5 = 974;

    static int eParam6 = 751;

    static int eParam7 = 734;

    static boolean eParam8 = true;

    static int eParam9 = 481;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int nPressed = 0;

    MouseEvent mousePressed(MouseEvent e) {
        nPressed++;
        System.out.println("Pressed!");
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12900().mousePressed(e);
    }
}
