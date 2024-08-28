import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_14084 {

    static Component eParam1 = new Container();

    static int eParam2 = 703;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 477;

    static int eParam5 = 818;

    static char eParam6 = Character.MIN_VALUE;

    static int eParam7 = 136;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7);

    static JTextField text = null;

    static JLabel label = null;

    KeyEvent keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int mods = e.getModifiers();
        if (code == '1' && mods == KeyEvent.SHIFT_MASK) {
            label.setText("KEYPRESS received for Shift+1");
        } else {
            label.setText(" ");
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14084().keyPressed(e);
    }
}
