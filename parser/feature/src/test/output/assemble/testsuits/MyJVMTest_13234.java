import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13234 {

    static boolean propValue = false;

    void testCase0() {
        if (!propValue) {
            throw new RuntimeException("TEST FAILED (0) : System property sun.awt.enableExtraMouseButtons = " + propValue);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13234().testCase0();
    }
}
