import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9399 {

    static String s = "`Tw,I2G)YL";

    String fail(String s) {
        throw new RuntimeException("Test failed: " + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9399().fail(s);
    }
}
