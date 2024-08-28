import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MyJVMTest_13344 {

    static List list = new ArrayList();

    void run() {
        list.requestFocusInWindow();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13344().run();
    }
}
