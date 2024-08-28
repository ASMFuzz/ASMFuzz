import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.text.*;
import java.util.*;
import static java.awt.Font.*;
import static java.awt.font.GraphicAttribute.*;
import static java.awt.font.ShapeGraphicAttribute.*;
import static java.awt.font.TextAttribute.*;
import java.math.BigInteger;

public class MyJVMTest_3062 {

    static int imParam1 = 774;

    static int imParam2 = 308;

    static int imParam3 = 287;

    static int imParam4Param1 = 668;

    static int imParam4Param2 = 662;

    static int[] imParam4Param3 = { 5, 4, 3, 1301069023, 8, 8, 3, -446888514, 0, 7 };

    static int imParam4Param4 = 906;

    static int imParam4Param5 = 793;

    static byte[] imParam4Param6Param1 = { 92, 30, 31, -88, 82, 56, -50, 83, -113, -68 };

    static BigInteger imParam4Param6 = new BigInteger(imParam4Param6Param1);

    static IndexColorModel imParam4 = new IndexColorModel(imParam4Param1, imParam4Param2, imParam4Param3, imParam4Param4, imParam4Param5, imParam4Param6);

    static BufferedImage im = new BufferedImage(imParam1, imParam2, imParam3, imParam4);

    static boolean DEBUG = true;

    static boolean DUMP = true;

    Rectangle computePixelBounds(BufferedImage im) {
        int w = im.getWidth();
        int h = im.getHeight();
        Formatter fmt = DEBUG ? new Formatter(System.err) : null;
        if (DUMP && DEBUG) {
            fmt.format("    ");
            for (int j = 0; j < w; ++j) {
                fmt.format("%2d", j);
            }
            for (int i = 0; i < h; ++i) {
                fmt.format("\n[%2d] ", i);
                for (int j = 0; j < w; ++j) {
                    fmt.format("%c ", im.getRGB(j, i) == -1 ? ' ' : '*');
                }
            }
            fmt.format("\n");
        }
        int l = -1, t = -1, r = w, b = h;
        {
            int[] buf = new int[w];
            loop: while (++t < h) {
                im.getRGB(0, t, buf.length, 1, buf, 0, w);
                for (int i = 0; i < buf.length; i++) {
                    if (buf[i] != -1) {
                        if (DEBUG)
                            fmt.format("top pixel at %d,%d = 0x%08x\n", i, t, buf[i]);
                        break loop;
                    }
                }
            }
            if (DEBUG)
                fmt.format("t: %d\n", t);
        }
        {
            int[] buf = new int[w];
            loop: while (--b > t) {
                im.getRGB(0, b, buf.length, 1, buf, 0, w);
                for (int i = 0; i < buf.length; ++i) {
                    if (buf[i] != -1) {
                        if (DEBUG)
                            fmt.format("bottom pixel at %d,%d = 0x%08x\n", i, b, buf[i]);
                        break loop;
                    }
                }
            }
            ++b;
            if (DEBUG)
                fmt.format("b: %d\n", b);
        }
        {
            loop: while (++l < r) {
                for (int i = t; i < b; ++i) {
                    int v = im.getRGB(l, i);
                    if (v != -1) {
                        if (DEBUG)
                            fmt.format("left pixel at %d,%d = 0x%08x\n", l, i, v);
                        break loop;
                    }
                }
            }
            if (DEBUG)
                fmt.format("l: %d\n", l);
        }
        {
            loop: while (--r > l) {
                for (int i = t; i < b; ++i) {
                    int v = im.getRGB(r, i);
                    if (v != -1) {
                        if (DEBUG)
                            fmt.format("right pixel at %d,%d = 0x%08x\n", r, i, v);
                        break loop;
                    }
                }
            }
            ++r;
            if (DEBUG)
                fmt.format("r: %d\n", r);
        }
        return new Rectangle(l, t, r - l, b - t);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3062().computePixelBounds(im));
    }
}
