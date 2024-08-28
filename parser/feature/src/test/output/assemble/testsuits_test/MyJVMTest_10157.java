import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_10157 {

    static Graphics2D g2D = null;

    static String fontParam1 = "PQ6-L$K:JH";

    static int fontParam2 = 844;

    static int fontParam3 = 648;

    static Font font = new Font(fontParam1, fontParam2, fontParam3);

    static float scale = 0.90184414f;

    static float x = Float.NaN;

    static float y = Float.MAX_VALUE;

    float printScale(Graphics2D g2D, Font font, float scale, float x, float y) {
        int RES = 72;
        g2D.scale(scale, scale);
        g2D.setFont(font.deriveFont(10.0f / scale));
        g2D.drawString("This text is scaled by a factor of " + scale, x * RES / scale, y * RES / scale);
        g2D.scale(1 / scale, 1 / scale);
        return scale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10157().printScale(g2D, font, scale, x, y);
    }
}
