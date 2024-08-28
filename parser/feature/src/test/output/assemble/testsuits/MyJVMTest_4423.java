import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4423 {

    static String testName = "e<Aa`:sI\"w";

    static JComboBox cb = null;

    static Robot robot = null;

    String checkResult(String testName) {
        if (!cb.isShowing()) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " failed");
            throw new RuntimeException("JComboBox is showing " + "after item selection.");
        }
        return testName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4423().checkResult(testName);
    }
}
