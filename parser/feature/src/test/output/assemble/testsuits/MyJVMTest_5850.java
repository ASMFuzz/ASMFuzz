import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_5850 {

    static Component comp = new Container();

    boolean checkFocusOwner(Component comp) {
        return (comp == KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5850().checkFocusOwner(comp));
    }
}
