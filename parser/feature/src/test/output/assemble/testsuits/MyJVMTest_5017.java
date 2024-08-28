import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5017 {

    void testCase1() {
        if (Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled() == false) {
            throw new RuntimeException("TEST FAILED (1) : setting to TRUE. enabled = " + Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5017().testCase1();
    }
}
