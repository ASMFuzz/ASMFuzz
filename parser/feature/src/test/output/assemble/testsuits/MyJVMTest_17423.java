import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_17423 {

    static Component eParam1 = new Container();

    static int eParam2 = 392;

    static long eParam3 = -2348545362431773797L;

    static int eParam4 = 702;

    static int eParam5 = 704;

    static char eParam6 = '0';

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static Frame frame = new Frame("Test Frame");

    static Button button = new Button("button");

    static boolean passed = false;

    static Robot robot = null;

    void init() {
        frame.add(button);
        button.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent e) {
                System.out.println("FocusSubRequestTest: focusGained for: " + e.getSource());
                ((Component) e.getSource()).requestFocus();
            }
        });
        button.addKeyListener(new KeyAdapter() {

            public KeyEvent keyPressed(KeyEvent e) {
                System.out.println("FocusSubRequestTest: keyPressed for: " + e.getSource());
                passed = true;
                return e;
            }
        });
        try {
            robot = new Robot();
        } catch (Exception e) {
            throw new RuntimeException("Error: unable to create robot", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17423().keyPressed(e);
    }
}
