import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_992 {

    static Component eParam1 = new Container();

    static int eParam2 = 184;

    static long eParam3 = 0;

    static int eParam4 = 647;

    static int eParam5 = 951;

    static int eParam6 = 448;

    static int eParam7 = 177;

    static boolean eParam8 = false;

    static int eParam9 = 29;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int[] buttonsReleased = {4,1999635415,1434756542,0,-1416165952,4,-1813314514,7,783028645,8};

    MouseEvent mouseReleased(MouseEvent e) {
        buttonsReleased[e.getButton() - 1] += 1;
        System.out.println("RELEASED " + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_992().mouseReleased(e);
    }
}
