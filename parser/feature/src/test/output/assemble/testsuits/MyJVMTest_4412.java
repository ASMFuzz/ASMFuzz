import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4412 {

    static Component eParam1 = new Container();

    static int eParam2 = 242;

    static FocusEvent e = new FocusEvent(eParam1, eParam2);

    FocusEvent focusGained(FocusEvent e) {
        System.out.println("FocusSubRequestTest: focusGained for: " + e.getSource());
        ((Component) e.getSource()).requestFocus();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4412().focusGained(e);
    }
}
