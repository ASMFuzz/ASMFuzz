import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4225 {

    static Component meParam1 = new Container();

    static int meParam2 = 521;

    static long meParam3 = -9223372036854775808L;

    static int meParam4 = 907;

    static int meParam5 = 237;

    static int meParam6 = 243;

    static int meParam7 = 793;

    static int meParam8 = 315;

    static int meParam9 = 351;

    static boolean meParam10 = true;

    static int meParam11 = 324;

    static MouseEvent me = new MouseEvent(meParam1, meParam2, meParam3, meParam4, meParam5, meParam6, meParam7, meParam8, meParam9, meParam10, meParam11);

    static boolean enterTriggered = false;

    MouseEvent mouseEntered(MouseEvent me) {
        System.out.println(me);
        enterTriggered = true;
        return me;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4225().mouseEntered(me);
    }
}
