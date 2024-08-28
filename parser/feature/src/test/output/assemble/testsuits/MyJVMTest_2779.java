import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2779 {

    static Window win = null;

    static boolean opened = false;

    void doOpen() {
        opened = true;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2779().doOpen();
    }
}
