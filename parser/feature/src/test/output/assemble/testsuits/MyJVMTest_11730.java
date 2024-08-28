import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11730 {

    static Component eParam1 = new Container();

    static int eParam2 = 821;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 849;

    static int eParam5 = 87;

    static int eParam6 = 153;

    static int eParam7 = 204;

    static boolean eParam8 = true;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8);

    static boolean dragged = false;

    MouseEvent mouseDragged(MouseEvent e) {
        System.out.println("Dragged " + e);
        dragged = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11730().mouseDragged(e);
    }
}
