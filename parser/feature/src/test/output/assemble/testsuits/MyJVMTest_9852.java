import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9852 {

    static boolean isAlwaysOnTop1 = false;

    static boolean isAlwaysOnTop2 = true;

    void checkResult() {
        try {
            Robot robot = new Robot();
            robot.waitForIdle();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Unexpected failure");
        }
        if (!isAlwaysOnTop1 || isAlwaysOnTop2) {
            throw new RuntimeException("Malicious applet can show always-on-top " + "popup menu which has whole screen size");
        }
        System.out.println("Test passed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9852().checkResult();
    }
}
