import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_8098 {

    static Component eParam1 = new Container();

    static int eParam2 = 397;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 481;

    static int eParam5 = 895;

    static int eParam6 = 818;

    static int eParam7 = 554;

    static boolean eParam8 = false;

    static int eParam9 = 155;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int[] buttonsPressed = {5,5,360959968,-1062851409,5,3,0,8,2,2046149743};

    MouseEvent mousePressed(MouseEvent e) {
        buttonsPressed[e.getButton() - 1] += 1;
        System.out.println("PRESSED " + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8098().mousePressed(e);
    }
}
