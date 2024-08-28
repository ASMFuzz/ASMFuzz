import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_17577 {

    static Component eParam1 = new Container();

    static int eParam2 = 410;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 263;

    static int eParam5 = 39;

    static int eParam6 = 376;

    static int eParam7 = 980;

    static boolean eParam8 = true;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8);

    static int[] buttonsClicked = {2,0,0,200461297,2,0,7,0,0,9};

    MouseEvent mouseClicked(MouseEvent e) {
        buttonsClicked[e.getButton() - 1] += 1;
        System.out.println("CLICKED " + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17577().mouseClicked(e);
    }
}
