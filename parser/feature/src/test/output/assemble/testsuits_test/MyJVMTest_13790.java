import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13790 {

    static Component eParam1 = new Container();

    static int eParam2 = 819;

    static boolean eParam3 = false;

    static FocusEvent e = new FocusEvent(eParam1, eParam2, eParam3);

    FocusEvent focusGained(FocusEvent e) {
        System.out.println("FocusSubRequestTest: focusGained for: " + e.getSource());
        ((Component) e.getSource()).requestFocus();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13790().focusGained(e);
    }
}
