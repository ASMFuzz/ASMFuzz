import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14451 {

    static boolean propValue = false;

    void testCase0() {
        if (propValue) {
            throw new RuntimeException("TEST FAILED (0): System property sun.awt.enableExtraMouseButtons = " + propValue);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14451().testCase0();
    }
}
