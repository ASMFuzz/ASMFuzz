import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7702 {

    static Component EVTParam1 = new Container();

    static int EVTParam2 = 463;

    static long EVTParam3 = -9223372036854775808L;

    static int EVTParam4 = 673;

    static int EVTParam5 = 473;

    static KeyEvent EVT = new KeyEvent(EVTParam1, EVTParam2, EVTParam3, EVTParam4, EVTParam5);

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
        new MyJVMTest_7702().keyPressed(EVT);
    }
}
