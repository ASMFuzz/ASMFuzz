import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_13070 {

    static int refImgParam1 = 463;

    static int refImgParam2 = 910;

    static int refImgParam3 = 489;

    static int refImgParam4Param1 = 849;

    static int refImgParam4Param2 = 404;

    static byte[] refImgParam4Param3 = { 9, 50, 120, -27, -33, -18, -4, 72, 73, -23 };

    static byte[] refImgParam4Param4 = { -36, 124, 64, -55, -100, 20, -127, 69, -51, 80 };

    static byte[] refImgParam4Param5 = { -116, -105, 45, 96, -79, -99, 95, 54, 96, 49 };

    static byte[] refImgParam4Param6 = { -69, 113, 87, -92, 10, 92, -103, -5, -83, -64 };

    static IndexColorModel refImgParam4 = new IndexColorModel(refImgParam4Param1, refImgParam4Param2, refImgParam4Param3, refImgParam4Param4, refImgParam4Param5, refImgParam4Param6);

    static BufferedImage refImg = new BufferedImage(refImgParam1, refImgParam2, refImgParam3, refImgParam4);

    static int testImgParam1 = 89;

    static int testImgParam2 = 532;

    static int testImgParam3 = 684;

    static BufferedImage testImg = new BufferedImage(testImgParam1, testImgParam2, testImgParam3);

    static int tolerance = 3;

    boolean isSameColor(Color c1, Color c2, int e) {
        int r1 = c1.getRed();
        int g1 = c1.getGreen();
        int b1 = c1.getBlue();
        int r2 = c2.getRed();
        int g2 = c2.getGreen();
        int b2 = c2.getBlue();
        int rmin = Math.max(r2 - e, 0);
        int gmin = Math.max(g2 - e, 0);
        int bmin = Math.max(b2 - e, 0);
        int rmax = Math.min(r2 + e, 255);
        int gmax = Math.min(g2 + e, 255);
        int bmax = Math.min(b2 + e, 255);
        if (r1 >= rmin && r1 <= rmax && g1 >= gmin && g1 <= gmax && b1 >= bmin && b1 <= bmax) {
            return true;
        }
        return false;
    }

    static RescaleOp rescale1band = null, rescale3band = null, rescale4band = null;

    BufferedImage compareImages(BufferedImage refImg, BufferedImage testImg, int tolerance) {
        int x1 = 0;
        int y1 = 0;
        int x2 = refImg.getWidth();
        int y2 = refImg.getHeight();
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                Color expected = new Color(refImg.getRGB(x, y));
                Color actual = new Color(testImg.getRGB(x, y));
                if (!isSameColor(expected, actual, tolerance)) {
                    throw new RuntimeException("Test failed at x=" + x + " y=" + y + " (expected=" + expected + " actual=" + actual + ")");
                }
            }
        }
        return refImg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13070().compareImages(refImg, testImg, tolerance);
    }
}
