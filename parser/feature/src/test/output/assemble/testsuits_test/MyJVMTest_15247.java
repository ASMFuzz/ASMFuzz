import javax.swing.*;
import java.awt.*;

public class MyJVMTest_15247 {

    static JFrame frame = null;

    static JInternalFrame jif = null;

    void setupUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDesktopPane desktop = new JDesktopPane();
        frame.add(desktop);
        jif = new JInternalFrame("Internal Frame", true, true, true, true);
        jif.setBounds(20, 20, 200, 100);
        desktop.add(jif);
        jif.setVisible(true);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds((screen.width - 400) / 2, (screen.height - 400) / 2, 400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15247().setupUI();
    }
}
