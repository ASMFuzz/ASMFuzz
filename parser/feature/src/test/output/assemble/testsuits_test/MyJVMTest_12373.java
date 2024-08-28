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

public class MyJVMTest_12373 {

    static int imParam1 = 69;

    static int imParam2 = 582;

    static int imParam3 = 8;

    static BufferedImage im = new BufferedImage(imParam1, imParam2, imParam3);

    static boolean DEBUG = true;

    static boolean DUMP = false;

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
        System.out.println(new MyJVMTest_12373().computePixelBounds(im));
    }
}
