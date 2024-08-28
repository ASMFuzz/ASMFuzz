import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_4689 {

    static Component eParam1 = new Container();

    static int eParam2 = 531;

    static long eParam3 = 0;

    static int eParam4 = 956;

    static int eParam5 = 758;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

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
        new MyJVMTest_4689().keyPressed(e);
    }
}
