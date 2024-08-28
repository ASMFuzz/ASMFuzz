import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14445 {

    static Component component = new Container();

    Point waitTillShown(Component component) {
        Point p = null;
        while (p == null) {
            try {
                p = component.getLocationOnScreen();
            } catch (IllegalStateException e) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
        return p;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14445().waitTillShown(component);
    }
}
