import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11317 {

    static String methodName = "VsL_;\"vWcO";

    static boolean newValue = true;

    static boolean oldValue = true;

    static String eventAsStr = "1`aY'*c[zu";

    boolean check(String methodName, boolean newValue, boolean oldValue, String eventAsStr) {
        if (newValue != oldValue) {
            throw new RuntimeException("Regression on " + methodName + ", newValue = " + newValue + ", oldValue = " + oldValue + ", e = " + eventAsStr);
        }
        return oldValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11317().check(methodName, newValue, oldValue, eventAsStr);
    }
}
