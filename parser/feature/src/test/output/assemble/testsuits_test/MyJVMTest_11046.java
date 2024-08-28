import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_11046 {

    static Graphics g = new Graphics2D();

    static boolean done = true;

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
        new MyJVMTest_11046().paint(g);
    }
}
