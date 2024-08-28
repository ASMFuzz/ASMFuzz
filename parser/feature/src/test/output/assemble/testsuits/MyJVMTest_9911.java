import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_9911 {

    static Graphics2D g2D = null;

    static String fontParam1 = "%Q]rD?8~A,";

    static int fontParam2 = 230;

    static int fontParam3 = 345;

    static Font font = new Font(fontParam1, fontParam2, fontParam3);

    static float scale = Float.MIN_VALUE;

    static float x = Float.MIN_VALUE;

    static float y = Float.MAX_VALUE;

    static Font customFont = null;

    float printScale(Graphics2D g2D, Font font, float scale, float x, float y) {
        int RES = 72;
        g2D.scale(scale, scale);
        g2D.setFont(font.deriveFont(10.0f / scale));
        g2D.drawString("This text is scaled by a factor of " + scale, x * RES / scale, y * RES / scale);
        g2D.scale(1 / scale, 1 / scale);
        return scale;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9911().printScale(g2D, font, scale, x, y);
    }
}
