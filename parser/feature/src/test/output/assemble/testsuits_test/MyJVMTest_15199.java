import java.io.*;
import java.util.*;
import static java.util.ResourceBundle.Control.*;

public class MyJVMTest_15199 {

    static ResourceBundle.Control control = new ResourceBundle.Control();

    static String testTitle = "qG@T)O4Ji=";

    String testControl(ResourceBundle.Control control, String testTitle) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("StressOut", control);
            throw new RuntimeException(testTitle);
        } catch (IllegalArgumentException e) {
            System.out.println(testTitle + ": PASSED (" + e.getMessage() + ")");
        }
        return testTitle;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15199().testControl(control, testTitle);
    }
}
