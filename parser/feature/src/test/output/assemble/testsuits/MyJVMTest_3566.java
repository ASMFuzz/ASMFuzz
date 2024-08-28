import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3566 {

    static Component eParam1 = new Container();

    static int eParam2 = 940;

    static long eParam3 = -6125763107239490476L;

    static int eParam4 = 184;

    static int eParam5 = 595;

    static int eParam6 = 731;

    static int eParam7 = 340;

    static boolean eParam8 = true;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8);

    static int nPressed = 0;

    MouseEvent mousePressed(MouseEvent e) {
        nPressed++;
        System.out.println("Pressed!");
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3566().mousePressed(e);
    }
}
