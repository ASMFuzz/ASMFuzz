import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import static java.awt.font.TextAttribute.*;

public class MyJVMTest_5813 {

    static int angle = 0;

    static boolean interactive = false;

    static DrawStrSuper dss = null;

    void run() {
        while (true) {
            if (!interactive && dss.angle > 360) {
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
            dss.angle += 10;
            dss.repaint();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5813().run();
    }
}
