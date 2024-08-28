import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13591 {

    static Component meParam1 = new Container();

    static int meParam2 = 481;

    static long meParam3 = 0;

    static int meParam4 = 194;

    static int meParam5 = 374;

    static int meParam6 = 775;

    static int meParam7 = 741;

    static boolean meParam8 = true;

    static MouseEvent me = new MouseEvent(meParam1, meParam2, meParam3, meParam4, meParam5, meParam6, meParam7, meParam8);

    static boolean enterTriggered = false;

    MouseEvent mouseEntered(MouseEvent me) {
        System.out.println(me);
        enterTriggered = true;
        return me;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13591().mouseEntered(me);
    }
}
