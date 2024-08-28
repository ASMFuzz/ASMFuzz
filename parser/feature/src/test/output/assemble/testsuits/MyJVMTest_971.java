import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_971 {

    static Graphics2D g2D = null;

    static Font font = null;

    static float scale = Float.NEGATIVE_INFINITY;

    static float x = Float.MAX_VALUE;

    static float y = Float.MIN_VALUE;

    float printScale(Graphics2D g2D, Font font, float scale, float x, float y) {
        int RES = 72;
        g2D.scale(scale, scale);
        g2D.setFont(font.deriveFont(10.0f / scale));
        g2D.drawString("This text is scaled by a factor of " + scale, x * RES / scale, y * RES / scale);
        g2D.scale(1 / scale, 1 / scale);
        return scale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_971().printScale(g2D, font, scale, x, y);
    }
}
