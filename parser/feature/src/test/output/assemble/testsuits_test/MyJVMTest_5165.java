import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5165 {

    static JFrame frame = null;

    static Toolkit toolkit = null;

    static Insets screenInsets = null;

    void run() {
        Dimension screenSize = toolkit.getScreenSize();
        frame.setLocation(screenSize.width / 2, screenSize.height - frame.getHeight() - screenInsets.bottom);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5165().run();
    }
}
