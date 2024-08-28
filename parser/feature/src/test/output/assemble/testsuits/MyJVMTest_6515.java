import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6515 {

    static Component eParam1 = new Container();

    static int eParam2 = 95;

    static long eParam3 = -8076172097833809380L;

    static int eParam4 = 857;

    static int eParam5 = 893;

    static int eParam6 = 150;

    static int eParam7 = 643;

    static boolean eParam8 = false;

    static int eParam9 = 836;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static String[] s = { "Choice 1", "Choice 2", "unselected choices", "what choices do I have?", "Will I pick the same thing in the future?" };

    static boolean passed = false;

    MouseEvent mouseReleased(MouseEvent e) {
        System.err.println("Test passed");
        passed = true;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6515().mouseReleased(e);
    }
}
