import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_14529 {

    static Component eParam1 = new Container();

    static int eParam2 = 275;

    static long eParam3 = 0;

    static int eParam4 = 782;

    static int eParam5 = 69;

    static int eParam6 = 355;

    static int eParam7 = 502;

    static boolean eParam8 = false;

    static int eParam9 = 302;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int mouseExitedCount = 0;

    MouseEvent mouseExited(MouseEvent e) {
        mouseExitedCount++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14529().mouseExited(e);
    }
}
