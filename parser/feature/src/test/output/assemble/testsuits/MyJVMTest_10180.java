import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_10180 {

    static Component eParam1 = new Container();

    static int eParam2 = 895;

    static long eParam3 = 1650179161887443205L;

    static int eParam4 = 788;

    static int eParam5 = 384;

    static int eParam6 = 108;

    static int eParam7 = 743;

    static boolean eParam8 = false;

    static int eParam9 = 345;

    static MouseEvent e = new MouseEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7, eParam8, eParam9);

    static int[] buttonsReleased = {-787287299,240015481,0,9,0,4,6,1,8,8};

    MouseEvent mouseReleased(MouseEvent e) {
        buttonsReleased[e.getButton() - 1] += 1;
        System.out.println("RELEASED " + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10180().mouseReleased(e);
    }
}
