import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3885 {

    static boolean pass = false;

    void pass() {
        pass = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3885().pass();
    }
}
