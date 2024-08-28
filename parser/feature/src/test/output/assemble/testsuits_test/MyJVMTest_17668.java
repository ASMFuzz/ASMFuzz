import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_17668 {

    static Component eParam1 = new Container();

    static int eParam2 = 175;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 866;

    static int eParam5 = 990;

    static int eParam6 = 748;

    static int eParam7 = 102;

    static boolean eParam8 = false;

    static int eParam9 = 504;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int[] buttonsPressed = {0,1,2,376491224,0,0,0,0,1,4};

    MouseEvent mousePressed(MouseEvent e) {
        buttonsPressed[e.getButton() - 1] += 1;
        System.out.println("PRESSED " + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17668().mousePressed(e);
    }
}
