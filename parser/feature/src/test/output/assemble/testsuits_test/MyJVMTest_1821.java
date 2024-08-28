import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_1821 {

    static Graphics g = new Graphics2D();

    static boolean done = false;

    Graphics paint(Graphics g) {
        synchronized (this) {
            if (!done) {
                done = true;
                notifyAll();
            }
        }
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1821().paint(g);
    }
}
