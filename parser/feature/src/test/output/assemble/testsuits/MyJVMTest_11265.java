import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_11265 {

    static float badColorParam1 = 0f;

    static float badColorParam2 = 0.27590412f;

    static float badColorParam3 = Float.MAX_VALUE;

    static Color badColor = new Color(badColorParam1, badColorParam2, badColorParam3);

    static BufferedImage bi = null;

    int checkBI(BufferedImage bi, Color badColor) {
        int badrgb = badColor.getRGB();
        int col = bi.getRGB(6, 9);
        if (col == badrgb) {
            throw new RuntimeException("A pixel was turned on. ");
        }
        return badrgb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11265().checkBI(bi, badColor);
    }
}
