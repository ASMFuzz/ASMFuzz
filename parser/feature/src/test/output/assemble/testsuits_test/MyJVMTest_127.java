import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_127 {

    static Component meParam1 = new Container();

    static int meParam2 = 463;

    static long meParam3 = -8576719176356105927L;

    static int meParam4 = 851;

    static int meParam5 = 780;

    static int meParam6 = 113;

    static int meParam7 = 902;

    static boolean meParam8 = false;

    static int meParam9 = 326;

    static MouseEvent me = new MouseEvent(meParam1, meParam2, meParam3, meParam4, meParam5, meParam6, meParam7, meParam8, meParam9);

    static boolean mouseReleased = false;

    MouseEvent mouseReleased(MouseEvent me) {
        mouseReleased = true;
        System.out.println(me);
        return me;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_127().mouseReleased(me);
    }
}
