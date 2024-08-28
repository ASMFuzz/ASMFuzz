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

public class MyJVMTest_16989 {

    static GlyphVector gv = null;

    static float x = Float.POSITIVE_INFINITY;

    static float y = 0f;

    static FontRenderContext frc = new FontRenderContext();

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

    static boolean DEBUG = false;

    static boolean DUMP = false;

    Rectangle computeLayoutBounds(GlyphVector gv, float x, float y, FontRenderContext frc) {
        Rectangle bounds = gv.getVisualBounds().getBounds();
        BufferedImage im = new BufferedImage(bounds.width + 4, bounds.height + 4, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = im.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, im.getWidth(), im.getHeight());
        float fx = (float) Math.IEEEremainder(x, 1);
        float fy = (float) Math.IEEEremainder(y, 1);
        g2d.setColor(Color.BLACK);
        g2d.drawGlyphVector(gv, fx + 2 - bounds.x, fy + 2 - bounds.y);
        Rectangle r = computePixelBounds(im);
        r.x += (int) Math.floor(x) - 2 + bounds.x;
        r.y += (int) Math.floor(y) - 2 + bounds.y;
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16989().computeLayoutBounds(gv, x, y, frc));
    }
}
