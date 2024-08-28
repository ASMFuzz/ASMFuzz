import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_10198 {

    static Component eParam1 = new Container();

    static int eParam2 = 26;

    static long eParam3 = 0;

    static int eParam4 = 590;

    static int eParam5 = 254;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static JTextField text = null;

    static JLabel label = null;

    KeyEvent keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 0x00e1) {
            label.setText("KEYPRESS received for aacute");
        } else {
            label.setText(" ");
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10198().keyPressed(e);
    }
}
