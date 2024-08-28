import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4700 {

    void createGui() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        menu = new JPopupMenu();
        menu.add(new JMenuItem("item"));
        panel.setComponentPopupMenu(menu);
        frame.add(panel);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static JFrame frame = null;

    static JPopupMenu menu = null;

    void run() {
        createGui();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4700().run();
    }
}
