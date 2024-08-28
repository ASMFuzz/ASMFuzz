import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9273 {

    static Component meParam1 = new Container();

    static int meParam2 = 216;

    static long meParam3 = 9223372036854775807L;

    static int meParam4 = 476;

    static int meParam5 = 607;

    static int meParam6 = 924;

    static int meParam7 = 294;

    static int meParam8 = 621;

    static int meParam9 = 888;

    static boolean meParam10 = false;

    static int meParam11 = 926;

    static MouseEvent me = new MouseEvent(meParam1, meParam2, meParam3, meParam4, meParam5, meParam6, meParam7, meParam8, meParam9, meParam10, meParam11);

    static boolean mouseReleased = false;

    MouseEvent mouseReleased(MouseEvent me) {
        mouseReleased = true;
        System.out.println(me);
        return me;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9273().mouseReleased(me);
    }
}
