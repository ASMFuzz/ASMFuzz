import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16028 {

    void run() {
        System.err.println("Dummy is here.");
        System.err.flush();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16028().run();
    }
}
