import java.awt.event.*;
import java.awt.*;

public class MyJVMTest_17455 {

    static Component c = new Container();

    Component waitTillShown(Component c) {
        while (true) {
            try {
                Thread.sleep(100);
                c.getLocationOnScreen();
                break;
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                break;
            } catch (IllegalComponentStateException e) {
            }
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17455().waitTillShown(c);
    }
}
