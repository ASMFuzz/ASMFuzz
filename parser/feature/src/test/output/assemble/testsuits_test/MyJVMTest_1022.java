import javax.swing.*;
import java.awt.*;

public class MyJVMTest_1022 {

    static JFrame frame = null;

    static JToolBar jToolBar1 = null;

    void run() {
        frame = new bug4529206();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1022().run();
    }
}
