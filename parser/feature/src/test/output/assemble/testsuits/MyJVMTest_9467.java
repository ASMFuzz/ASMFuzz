import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_9467 {

    static Graphics2D g2d = null;

    static Paint p = null;

    static Object aahint = 377370327;

    static int TESTW = 600;

    static int TESTH = 500;

    Graphics2D renderTest(Graphics2D g2d, Paint p, Object aahint) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, TESTW, TESTH);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, aahint);
        g2d.setPaint(p);
        g2d.fillOval(0, 0, TESTW, TESTH);
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9467().renderTest(g2d, p, aahint);
    }
}
