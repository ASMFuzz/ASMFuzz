import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_1010 {

    static Component eParam1 = new Container();

    static int eParam2 = 785;

    static long eParam3 = -1978185957046399764L;

    static int eParam4 = 294;

    static int eParam5 = 104;

    static char eParam6 = Character.MAX_VALUE;

    static int eParam7 = 803;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6, eParam7);

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
        new MyJVMTest_1010().keyPressed(e);
    }
}
