import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9392 {

    static JFrame frame = null;

    static JToolBar jToolBar1 = null;

    void run() {
        if (frame.isFocused()) {
            throw (new RuntimeException("setFloating does not work correctly"));
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9392().run();
    }
}
