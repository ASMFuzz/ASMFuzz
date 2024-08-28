import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_18209 {

    static boolean pass = true;

    void waitTestResult() throws InterruptedException {
        while (!pass) {
            wait();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18209().waitTestResult();
    }
}
