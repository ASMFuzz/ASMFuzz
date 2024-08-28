import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13229 {

    static boolean pass = true;

    void pass() {
        pass = true;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13229().pass();
    }
}
