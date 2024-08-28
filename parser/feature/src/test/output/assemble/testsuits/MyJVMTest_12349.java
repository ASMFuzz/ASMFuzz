import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;

public class MyJVMTest_12349 {

    static int biParam1 = 891;

    static int biParam2 = 987;

    static int biParam3 = 940;

    static int biParam4Param1 = 621;

    static int biParam4Param2 = 558;

    static byte[] biParam4Param3 = { -98, -51, 0, -33, 90, 81, -42, 17, -71, 47 };

    static byte[] biParam4Param4 = { 14, -21, 54, -72, 3, -41, 117, -51, 66, 66 };

    static byte[] biParam4Param5 = { 84, -20, 50, 117, 78, 63, -54, 11, 24, 23 };

    static int biParam4Param6 = 995;

    static IndexColorModel biParam4 = new IndexColorModel(biParam4Param1, biParam4Param2, biParam4Param3, biParam4Param4, biParam4Param5, biParam4Param6);

    static BufferedImage bi = new BufferedImage(biParam1, biParam2, biParam3, biParam4);

    static Color badColor = new Color();

    BufferedImage checkBI(BufferedImage bi, Color badColor) {
        int badrgb = badColor.getRGB();
        int w = bi.getWidth(null);
        int h = bi.getHeight(null);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                int col = bi.getRGB(x, y);
                if (col == badrgb) {
                    throw new RuntimeException("Got " + col);
                }
            }
        }
        return bi;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12349().checkBI(bi, badColor);
    }
}
