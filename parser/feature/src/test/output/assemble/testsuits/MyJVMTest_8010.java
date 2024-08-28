import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_8010 {

    static Component eParam1 = new Container();

    static int eParam2 = 708;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 898;

    static int eParam5 = 898;

    static int eParam6 = 210;

    static int eParam7 = 0;

    static boolean eParam8 = false;

    static int eParam9 = 232;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int[] buttonsClicked = {8,893262972,0,6,6,9,9,7,-2009238144,0};

    MouseEvent mouseClicked(MouseEvent e) {
        buttonsClicked[e.getButton() - 1] += 1;
        System.out.println("CLICKED " + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8010().mouseClicked(e);
    }
}
