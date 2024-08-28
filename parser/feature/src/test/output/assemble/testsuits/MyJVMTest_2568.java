import javax.swing.*;
import java.awt.*;

public class MyJVMTest_2568 {

    static Robot robot = null;

    void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2568().delay();
    }
}
