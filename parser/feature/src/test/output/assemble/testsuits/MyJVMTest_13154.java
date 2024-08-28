import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13154 {

    void createGui() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(true);
        popup = new JPopupMenu("Menu");
        for (int i = 0; i < 7; i++) {
            popup.add(new JMenuItem("MenuItem"));
        }
        JPanel panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        frame.add(panel);
        frame.setSize(200, 200);
    }

    static JFrame frame = null;

    static JPopupMenu popup = null;

    void run() {
        createGui();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13154().run();
    }
}
