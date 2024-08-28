import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_10273 {

    static Component eParam1 = new Container();

    static int eParam2 = 954;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 202;

    static int eParam5 = 561;

    static int eParam6 = 388;

    static int eParam7 = 880;

    static int eParam8 = 625;

    static int eParam9 = 396;

    static boolean eParam10 = true;

    static int eParam11 = 395;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9, eParam10, eParam11);

    static int mouseEnteredCount = 0;

    MouseEvent mouseEntered(MouseEvent e) {
        mouseEnteredCount++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10273().mouseEntered(e);
    }
}
