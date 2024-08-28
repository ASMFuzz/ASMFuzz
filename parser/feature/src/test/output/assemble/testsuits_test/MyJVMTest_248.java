import javax.swing.*;
import java.awt.*;

public class MyJVMTest_248 {

    static String s = "V7,g^!D.P$";

    String fail(String s) {
        throw new RuntimeException("Test failed: " + s);
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_248().fail(s);
    }
}
