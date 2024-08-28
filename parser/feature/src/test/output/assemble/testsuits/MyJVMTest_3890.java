import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3890 {

    static boolean propValue = true;

    void testCase0() {
        if (!propValue) {
            throw new RuntimeException("TEST FAILED (0) : System property sun.awt.enableExtraMouseButtons = " + propValue);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3890().testCase0();
    }
}
