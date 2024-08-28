import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12021 {

    static Component eParam1 = new Container();

    static int eParam2 = 788;

    static long eParam3 = -739470906603021111L;

    static int eParam4 = 91;

    static int eParam5 = 584;

    static char eParam6 = Character.MIN_VALUE;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static Frame frame = null;

    static int listenerCallCounter = 0;

    void createAndShowGUI() {
        frame = new Frame("Test");
        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                listenerCallCounter++;
            }

            @Override
            public KeyEvent keyReleased(KeyEvent e) {
                listenerCallCounter++;
                return e;
            }
        });
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12021().keyReleased(e);
    }
}
