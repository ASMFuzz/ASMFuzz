import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16039 {

    static Component eParam1 = new Container();

    static int eParam2 = 764;

    static long eParam3 = -9223372036854775808L;

    static int eParam4 = 694;

    static int eParam5 = 547;

    static KeyEvent e = new KeyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

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
            robot.setAutoDelay(100);
        } catch (Exception e) {
            throw new RuntimeException("Error: unable to create robot", e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16039().keyPressed(e);
    }
}
