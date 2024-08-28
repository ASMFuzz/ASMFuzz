import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_733 {

    static Graphics2D g2D = null;

    static Font font = null;

    static float scale = 0.26656884f;

    static float x = Float.POSITIVE_INFINITY;

    static float y = Float.POSITIVE_INFINITY;

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
        new MyJVMTest_733().printScale(g2D, font, scale, x, y);
    }
}
