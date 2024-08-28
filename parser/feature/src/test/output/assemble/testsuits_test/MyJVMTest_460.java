import javax.swing.*;
import java.awt.*;

public class MyJVMTest_460 {

    static JPopupMenu popupMenu = null;

    static JFrame frame = null;

    static boolean isAlwaysOnTop2 = true;

    void testApplet() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                System.setSecurityManager(new SecurityManager());
                popupMenu.show(frame, 0, 0);
                Window popupWindow = (Window) (popupMenu.getParent().getParent().getParent().getParent());
                isAlwaysOnTop2 = popupWindow.isAlwaysOnTop();
                System.out.println("Applet: popupWindow.isAlwaysOnTop() = " + isAlwaysOnTop2);
                popupMenu.setVisible(false);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_460().run();
    }
}
