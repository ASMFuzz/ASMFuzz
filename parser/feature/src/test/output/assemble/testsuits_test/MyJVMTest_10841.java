import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_10841 {

    static Component c = new Container();

    Component waitTillShown(Component c) {
        while (true) {
            try {
                Thread.sleep(100);
                c.getLocationOnScreen();
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IllegalComponentStateException e) {
            }
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10841().waitTillShown(c);
    }
}
