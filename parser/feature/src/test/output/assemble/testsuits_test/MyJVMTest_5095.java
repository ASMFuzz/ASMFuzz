import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5095 {

    static JFrame frame = null;

    void stopEDT() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5095().run();
    }
}
