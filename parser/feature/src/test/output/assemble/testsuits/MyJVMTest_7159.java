import javax.swing.*;
import java.awt.*;

public class MyJVMTest_7159 {

    static JTable table = null;

    void run() {
        bug7068740 test = new bug7068740();
        test.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7159().run();
    }
}
