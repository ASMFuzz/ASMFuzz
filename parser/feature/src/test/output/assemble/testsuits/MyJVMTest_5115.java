import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_5115 {

    static Component eParam1 = new Container();

    static int eParam2 = 508;

    static long eParam3 = 7049982307307807995L;

    static int eParam4 = 99;

    static int eParam5 = 283;

    static int eParam6 = 589;

    static int eParam7 = 45;

    static boolean eParam8 = false;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8);

    static int mouseExitedCount = 0;

    MouseEvent mouseExited(MouseEvent e) {
        mouseExitedCount++;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5115().mouseExited(e);
    }
}
