import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5750 {

    static JFrame frame = null;

    void run() {
        if (frame != null) {
            frame.dispose();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5750().run();
    }
}
