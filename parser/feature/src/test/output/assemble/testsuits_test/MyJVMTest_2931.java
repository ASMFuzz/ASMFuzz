import javax.swing.*;
import java.awt.*;

public class MyJVMTest_2931 {

    static boolean b = false;

    boolean assertTrue(boolean b) {
        if (!b) {
            throw new RuntimeException("Assertion failed");
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2931().assertTrue(b);
    }
}
