import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9421 {

    static Window win1 = null;

    static Window win2 = null;

    static Point point = null;

    void run() {
        point = win1.getLocationOnScreen();
        win2.setBounds(win1.getBounds());
        win2.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9421().run();
    }
}
