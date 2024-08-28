import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_17254 {

    static Component EVTParam1 = new Container();

    static int EVTParam2 = 805;

    static long EVTParam3 = 9223372036854775807L;

    static int EVTParam4 = 167;

    static int EVTParam5 = 714;

    static char EVTParam6 = '0';

    static int EVTParam7 = 126;

    static KeyEvent EVT = new KeyEvent(EVTParam1, EVTParam2, EVTParam3, EVTParam4, EVTParam5, EVTParam6, EVTParam7);

    KeyEvent keyPressed(KeyEvent EVT) {
        if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z') {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return EVT;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17254().keyPressed(EVT);
    }
}
