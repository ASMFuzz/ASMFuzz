import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5210 {

    static Component eParam1 = new Container();

    static int eParam2 = 653;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 314;

    static int eParam5 = 93;

    static int eParam6 = 441;

    static int eParam7 = 69;

    static boolean eParam8 = true;

    static int eParam9 = 445;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static boolean moved = false;

    MouseEvent mouseMoved(MouseEvent e) {
        System.out.println("Moved " + e);
        moved = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5210().mouseMoved(e);
    }
}
