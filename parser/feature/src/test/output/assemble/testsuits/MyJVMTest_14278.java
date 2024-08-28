import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14278 {

    static Component component = new Container();

    Component waitTillShown(Component component) {
        while (true) {
            try {
                Thread.sleep(100);
                component.getLocationOnScreen();
                break;
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            } catch (IllegalComponentStateException icse) {
            }
        }
        return component;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14278().waitTillShown(component);
    }
}
