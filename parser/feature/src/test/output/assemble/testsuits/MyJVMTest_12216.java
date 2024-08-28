import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_12216 {

    void createAndShowGUI() {
        frame = new JFrame("Main Frame");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseEnteredCount++;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseExitedCount++;
            }
        });
        frame.setVisible(true);
    }

    void mouseEntered(MouseEvent e) {
        mouseEnteredCount++;
    }

    void mouseExited(MouseEvent e) {
        mouseExitedCount++;
    }

    static int mouseEnteredCount = 0;

    static int mouseExitedCount = 0;

    static JFrame frame = null;

    void run() {
        createAndShowGUI();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12216().run();
    }
}
