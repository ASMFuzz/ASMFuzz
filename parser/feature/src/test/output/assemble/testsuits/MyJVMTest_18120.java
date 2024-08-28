import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_18120 {

    static Component meParam1 = new Container();

    static int meParam2 = 650;

    static long meParam3 = -9223372036854775808L;

    static int meParam4 = 46;

    static int meParam5 = 119;

    static int meParam6 = 824;

    static int meParam7 = 950;

    static boolean meParam8 = true;

    static int meParam9 = 778;

    static MouseEvent me = new MouseEvent(meParam1, meParam2, meParam3, meParam4, meParam5, meParam6, meParam7, meParam8, meParam9);

    static boolean mousePressed = false;

    MouseEvent mousePressed(MouseEvent me) {
        mousePressed = true;
        System.out.println(me);
        return me;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18120().mousePressed(me);
    }
}
