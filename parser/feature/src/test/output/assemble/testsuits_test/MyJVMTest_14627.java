import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14627 {

    static Component eParam1 = new Container();

    static int eParam2 = 344;

    static long eParam3 = 0;

    static int eParam4 = 69;

    static int eParam5 = 724;

    static int eParam6 = 357;

    static int eParam7 = 676;

    static int eParam8 = 413;

    static int eParam9 = 130;

    static boolean eParam10 = true;

    static int eParam11 = 26;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9, eParam10, eParam11);

    static boolean moved = false;

    MouseEvent mouseMoved(MouseEvent e) {
        System.out.println("Moved " + e);
        moved = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14627().mouseMoved(e);
    }
}
