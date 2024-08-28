import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2463 {

    static Component eParam1 = new Container();

    static int eParam2 = 391;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 247;

    static int eParam5 = 267;

    static int eParam6 = 540;

    static int eParam7 = 465;

    static int eParam8 = 434;

    static int eParam9 = 854;

    static boolean eParam10 = false;

    static int eParam11 = 231;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9, eParam10, eParam11);

    static boolean dragged = false;

    MouseEvent mouseDragged(MouseEvent e) {
        System.out.println("Dragged " + e);
        dragged = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2463().mouseDragged(e);
    }
}
