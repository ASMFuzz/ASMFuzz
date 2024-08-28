import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14005 {

    void run() {
        System.err.println("Dummy from pop");
        System.err.flush();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14005().run();
    }
}
