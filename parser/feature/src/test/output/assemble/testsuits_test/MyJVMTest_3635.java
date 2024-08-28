import javax.swing.*;
import java.awt.*;

public class MyJVMTest_3635 {

    static JFrame frame = null;

    static JPopupMenu menu = null;

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

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3635().createGui();
    }
}
