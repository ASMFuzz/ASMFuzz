import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14250 {

    static Component c = new Container();

    static Button b = null;

    static Dialog d = null;

    Component waitTillShown(Component c) {
        while (true) {
            try {
                Thread.sleep(100);
                c.getLocationOnScreen();
                break;
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                break;
            } catch (Exception e) {
            }
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14250().waitTillShown(c);
    }
}
