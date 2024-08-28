import javax.swing.*;
import java.awt.*;

public class MyJVMTest_241 {

    static JFrame frame = null;

    static JToolBar jToolBar1 = null;

    void run() {
        if (frame.isFocused()) {
            throw (new RuntimeException("setFloating does not work correctly"));
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_241().run();
    }
}
