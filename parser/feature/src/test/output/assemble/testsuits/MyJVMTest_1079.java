import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_1079 {

    static Component eParam1 = new Container();

    static int eParam2 = 603;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 345;

    static int eParam5 = 965;

    static int eParam6 = 944;

    static int eParam7 = 505;

    static boolean eParam8 = true;

    static int eParam9 = 88;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int mouseEnteredCount = 0;

    MouseEvent mouseEntered(MouseEvent e) {
        mouseEnteredCount++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1079().mouseEntered(e);
    }
}
