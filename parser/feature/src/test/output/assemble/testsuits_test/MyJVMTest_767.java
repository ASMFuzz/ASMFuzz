import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_767 {

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    void checkResult() {
        if (passed) {
            System.out.println("Test passed");
        } else {
            throw new RuntimeException("The thumb moved " + "to the right instead of the left!");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_767().checkResult();
    }
}
