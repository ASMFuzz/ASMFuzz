import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4178 {

    static JPopupMenu popupMenu = null;

    static JFrame frame = null;

    static boolean isAlwaysOnTop1 = false;

    void run() {
        popupMenu.show(frame, 0, 0);
        Window popupWindow = (Window) (popupMenu.getParent().getParent().getParent().getParent());
        isAlwaysOnTop1 = popupWindow.isAlwaysOnTop();
        System.out.println("Application: popupWindow.isAlwaysOnTop() = " + isAlwaysOnTop1);
        popupMenu.setVisible(false);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4178().run();
    }
}
