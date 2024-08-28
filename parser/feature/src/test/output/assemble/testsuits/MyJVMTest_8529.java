import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_8529 {

    static Component meParam1 = new Container();

    static int meParam2 = 1;

    static long meParam3 = -9223372036854775808L;

    static int meParam4 = 534;

    static int meParam5 = 468;

    static int meParam6 = 862;

    static int meParam7 = 782;

    static boolean meParam8 = false;

    static MouseEvent me = new MouseEvent(meParam1, meParam2, meParam3, meParam4, meParam5, meParam6, meParam7, meParam8);

    static boolean mousePressed = false;

    MouseEvent mousePressed(MouseEvent me) {
        mousePressed = true;
        System.out.println(me);
        return me;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8529().mousePressed(me);
    }
}
