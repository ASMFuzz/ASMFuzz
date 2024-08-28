import javax.swing.*;
import java.awt.*;

public class MyJVMTest_15559 {

    static JFrame frame = null;

    void run() {
        frame = new ComponentTest();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15559().run();
    }
}
