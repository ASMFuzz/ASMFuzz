import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_10865 {

    static int biParam1 = 66;

    static int biParam2 = 289;

    static int biParam3 = 690;

    static int biParam4Param1 = 740;

    static int biParam4Param2 = 251;

    static int[] biParam4Param3 = { 1, -1577624595, 3, 0, 0, -777198736, 0, 4, -1782173495, 0 };

    static int biParam4Param4 = 985;

    static boolean biParam4Param5 = true;

    static int biParam4Param6 = 153;

    static int biParam4Param7 = 663;

    static IndexColorModel biParam4 = new IndexColorModel(biParam4Param1, biParam4Param2, biParam4Param3, biParam4Param4, biParam4Param5, biParam4Param6, biParam4Param7);

    static BufferedImage bi = new BufferedImage(biParam1, biParam2, biParam3, biParam4);

    static String name = "Hr)7Et|v$C";

    static int x1 = 1;

    static int y1 = -1361237844;

    static int x2 = 0;

    static int y2 = -102823726;

    static int expected = 8;

    int testRegion(BufferedImage bi, String name, int x1, int y1, int x2, int y2, int expected) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                int actual = bi.getRGB(x, y);
                if (actual != expected) {
                    throw new RuntimeException("Test failed for " + name + " region at x=" + x + " y=" + y + " (expected=" + Integer.toHexString(expected) + " actual=" + Integer.toHexString(actual) + ")");
                }
            }
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10865().testRegion(bi, name, x1, y1, x2, y2, expected);
    }
}
