import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_9944 {

    static Component eParam1 = new Container();

    static int eParam2 = 951;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 392;

    static int eParam5 = 631;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean passed = true;

    KeyEvent keyTyped(KeyEvent e) {
        System.out.println(e.toString());
        passed = false;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9944().keyTyped(e);
    }
}
