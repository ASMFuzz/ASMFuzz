import java.awt.event.*;
import java.awt.*;

public class MyJVMTest_15278 {

    void run() {
        System.err.println("Dummy from SunToolkit");
        System.err.flush();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15278().run();
    }
}
