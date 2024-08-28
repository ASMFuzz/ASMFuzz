import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_11842 {

    static Component eParam1 = new Container();

    static int eParam2 = 518;

    static long eParam3 = 9223372036854775807L;

    static int eParam4 = 109;

    static int eParam5 = 122;

    static char eParam6 = 'o';

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    Frame keyPressed(KeyEvent e) {
        Frame frame = new Frame();
        frame.setVisible(true);
        try {
            Thread.sleep(2);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        frame.dispose();
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11842().keyPressed(e);
    }
}
