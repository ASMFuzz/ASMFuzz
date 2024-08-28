import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_1643 {

    static BufferedImage bi = null;

    static String name = ",v=AK!&2S`";

    static int x1 = -2130650786;

    static int y1 = 1;

    static int x2 = 1;

    static int y2 = 0;

    static int expected = 0;

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
        new MyJVMTest_1643().testRegion(bi, name, x1, y1, x2, y2, expected);
    }
}
