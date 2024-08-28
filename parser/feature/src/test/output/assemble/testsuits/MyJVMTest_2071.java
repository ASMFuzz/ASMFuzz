import javax.swing.*;
import java.awt.*;

public class MyJVMTest_2071 {

    static String methodName = " |)$\\^rnhT";

    static boolean newValue = true;

    static boolean oldValue = false;

    static String eventAsStr = "OYl}1omX`w";

    boolean check(String methodName, boolean newValue, boolean oldValue, String eventAsStr) {
        if (newValue != oldValue) {
            throw new RuntimeException("Regression on " + methodName + ", newValue = " + newValue + ", oldValue = " + oldValue + ", e = " + eventAsStr);
        }
        return oldValue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2071().check(methodName, newValue, oldValue, eventAsStr);
    }
}
