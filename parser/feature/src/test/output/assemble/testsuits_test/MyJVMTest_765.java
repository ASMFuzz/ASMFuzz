import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_765 {

    static Component eParam1 = new Container();

    static int eParam2 = 637;

    static long eParam3 = -1210050505749978255L;

    static int eParam4 = 53;

    static int eParam5 = 426;

    static char eParam6 = Character.MIN_VALUE;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static boolean passed = true;

    KeyEvent keyTyped(KeyEvent e) {
        System.out.println(e.toString());
        passed = false;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_765().keyTyped(e);
    }
}
