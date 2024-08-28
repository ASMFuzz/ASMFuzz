import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1362 {

    void testCase1() {
        if (Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled() == true) {
            throw new RuntimeException("TEST FAILED (1): setting to FALSE. Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled() = " + Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled());
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1362().testCase1();
    }
}
