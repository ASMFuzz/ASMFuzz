import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5087 {

    static UIManager.LookAndFeelInfo laf = null;

    static JFrame frame1 = null;

    static JFrame frame2 = null;

    void disposeUI() {
        frame1.dispose();
        frame2.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5087().disposeUI();
    }
}
