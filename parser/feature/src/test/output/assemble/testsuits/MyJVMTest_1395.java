import javax.swing.*;
import java.awt.*;

public class MyJVMTest_1395 {

    static JFrame frame = null;

    static JComponent comp2 = null;

    void run() {
        if (comp2.getLocation().getY() > frame.getHeight())
            throw new RuntimeException("GroupLayout fails: comp2 is out of the window");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1395().run();
    }
}
