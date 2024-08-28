import javax.swing.*;
import java.awt.*;

public class MyJVMTest_15193 {

    static JFrame frame = null;

    void run() {
        if (frame != null) {
            frame.dispose();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15193().run();
    }
}
