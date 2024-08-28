import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16006 {

    static Component eParam1 = new Container();

    static int eParam2 = 27;

    static long eParam3 = 0;

    static int eParam4 = 214;

    static int eParam5 = 449;

    static int eParam6 = 750;

    static int eParam7 = 420;

    static int eParam8 = 397;

    static int eParam9 = 336;

    static boolean eParam10 = true;

    static int eParam11 = 14;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9, eParam10, eParam11);

    static String[] s = { "Choice 1", "Choice 2", "unselected choices", "what choices do I have?", "Will I pick the same thing in the future?" };

    static boolean passed = false;

    MouseEvent mouseReleased(MouseEvent e) {
        System.err.println("Test passed");
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16006().mouseReleased(e);
    }
}
