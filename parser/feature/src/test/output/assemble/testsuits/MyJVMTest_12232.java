import javax.swing.*;
import java.awt.*;

public class MyJVMTest_12232 {

    static boolean b = false;

    boolean assertTrue(boolean b) {
        if (!b) {
            throw new RuntimeException("Assertion failed");
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12232().assertTrue(b);
    }
}
