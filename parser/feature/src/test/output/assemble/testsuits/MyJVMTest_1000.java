import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_1000 {

    static int bi0Param1 = 841;

    static int bi0Param2 = 115;

    static int bi0Param3 = 828;

    static BufferedImage bi0 = new BufferedImage(bi0Param1, bi0Param2, bi0Param3);

    static int bi1Param1 = 100;

    static int bi1Param2 = 395;

    static int bi1Param3 = 764;

    static int bi1Param4Param1 = 883;

    static int bi1Param4Param2 = 44;

    static byte[] bi1Param4Param3 = { -63, 63, -126, 47, -66, 95, -71, -119, -52, -22 };

    static int bi1Param4Param4 = 892;

    static boolean bi1Param4Param5 = false;

    static IndexColorModel bi1Param4 = new IndexColorModel(bi1Param4Param1, bi1Param4Param2, bi1Param4Param3, bi1Param4Param4, bi1Param4Param5);

    static BufferedImage bi1 = new BufferedImage(bi1Param1, bi1Param2, bi1Param3, bi1Param4);

    static int biType = 8;

    static int cParam1 = 465;

    static Color c = new Color(cParam1);

    static int wid = 400, hgt = 200;

    int compare(BufferedImage bi0, BufferedImage bi1, int biType, Color c) {
        for (int x = 0; x < wid; x++) {
            for (int y = 0; y < hgt; y++) {
                int rgb0 = bi0.getRGB(x, y);
                int rgb1 = bi1.getRGB(x, y);
                if (rgb0 == rgb1)
                    continue;
                int r0 = (rgb0 & 0xff0000) >> 16;
                int r1 = (rgb1 & 0xff0000) >> 16;
                int rdiff = r0 - r1;
                if (rdiff < 0)
                    rdiff = -rdiff;
                int g0 = (rgb0 & 0x00ff00) >> 8;
                int g1 = (rgb1 & 0x00ff00) >> 8;
                int gdiff = g0 - g1;
                if (gdiff < 0)
                    gdiff = -gdiff;
                int b0 = (rgb0 & 0x0000ff);
                int b1 = (rgb1 & 0x0000ff);
                int bdiff = b0 - b1;
                if (bdiff < 0)
                    bdiff = -bdiff;
                if (rdiff > 1 || gdiff > 1 || bdiff > 1) {
                    throw new RuntimeException("Images differ for type " + biType + " col=" + c + " at x=" + x + " y=" + y + " " + Integer.toHexString(rgb0) + " vs " + Integer.toHexString(rgb1));
                }
            }
        }
        return biType;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1000().compare(bi0, bi1, biType, c);
    }
}
