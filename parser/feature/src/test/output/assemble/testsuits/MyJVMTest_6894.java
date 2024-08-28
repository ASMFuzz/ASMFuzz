import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_6894 {

    static Component eParam1 = new Container();

    static int eParam2 = 815;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 689;

    static int eParam5 = 120;

    static char eParam6 = Character.MAX_VALUE;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static boolean passed = true;

    KeyEvent keyTyped(KeyEvent e) {
        Sysout.println(e.toString());
        passed = false;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6894().keyTyped(e);
    }
}
