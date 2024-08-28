import java.awt.*;
import java.awt.image.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_16872 {

    static int biParam1 = 701;

    static int biParam2 = 920;

    static int biParam3 = 938;

    static BufferedImage bi = new BufferedImage(biParam1, biParam2, biParam3);

    static ICC_Profile cParam1Param1 = null;

    static ColorSpace cParam1 = new ICC_ColorSpace(cParam1Param1);

    static float[] cParam2 = { 0.9418809f, 0f, Float.MAX_VALUE, Float.NaN, 0.8667599f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE };

    static float cParam3 = 0f;

    static Color c = new Color(cParam1, cParam2, cParam3);

    static int wid = 400, hgt = 200;

    Graphics2D drawText(BufferedImage bi, Color c) {
        Graphics2D g = bi.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(c);
        g.setFont(new Font("sansserif", Font.PLAIN, 70));
        g.drawString("Hello!", 20, 100);
        g.setFont(new Font("sansserif", Font.PLAIN, 12));
        g.drawString("Hello!", 20, 130);
        g.setFont(new Font("sansserif", Font.PLAIN, 10));
        g.drawString("Hello!", 20, 150);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16872().drawText(bi, c);
    }
}
