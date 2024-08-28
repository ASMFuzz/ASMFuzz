import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16404 {

    static Component eParam1 = new Container();

    static int eParam2 = 514;

    static long eParam3 = 691877333883085555L;

    static int eParam4 = 908;

    static int eParam5 = 668;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean passed = true;

    KeyEvent keyTyped(KeyEvent e) {
        Sysout.println(e.toString());
        passed = false;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16404().keyTyped(e);
    }
}
