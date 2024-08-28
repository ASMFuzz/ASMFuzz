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

public class MyJVMTest_17214 {

    static AttributedCharacterIterator tlParam1 = null;

    static float[] tlParam2Param1Param1 = { 0f, 0.2760744f, Float.NaN, Float.POSITIVE_INFINITY, 0.8162986f, Float.MAX_VALUE, 0.42750573f, Float.NaN, 0.62674713f, 0.5595189f };

    static AffineTransform tlParam2Param1 = new AffineTransform(tlParam2Param1Param1);

    static Object tlParam2Param2 = 0;

    static Object tlParam2Param3 = 666640877;

    static FontRenderContext tlParam2 = new FontRenderContext(tlParam2Param1, tlParam2Param2, tlParam2Param3);

    static TextLayout tl = new TextLayout(tlParam1, tlParam2);

    static float x = Float.NaN;

    static float y = 0.34882134f;

    static double frcParam1Param1 = 0.5691920622474386;

    static double frcParam1Param2 = Double.MAX_VALUE;

    static double frcParam1Param3 = 0.025765259863824275;

    static double frcParam1Param4 = 0d;

    static double frcParam1Param5 = Double.NaN;

    static double frcParam1Param6 = 0.5643924622561218;

    static AffineTransform frcParam1 = new AffineTransform(frcParam1Param1, frcParam1Param2, frcParam1Param3, frcParam1Param4, frcParam1Param5, frcParam1Param6);

    static boolean frcParam2 = true;

    static boolean frcParam3 = false;

    static FontRenderContext frc = new FontRenderContext(frcParam1, frcParam2, frcParam3);

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

    static boolean DEBUG = true;

    static boolean DUMP = true;

    Rectangle computeLayoutBounds(TextLayout tl, float x, float y, FontRenderContext frc) {
        Rectangle bounds = tl.getBounds().getBounds();
        BufferedImage im = new BufferedImage(bounds.width + 4, bounds.height + 4, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = im.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, im.getWidth(), im.getHeight());
        float fx = (float) Math.IEEEremainder(x, 1);
        float fy = (float) Math.IEEEremainder(y, 1);
        g2d.setColor(Color.BLACK);
        tl.draw(g2d, fx + 2 - bounds.x, fy + 2 - bounds.y);
        Rectangle r = computePixelBounds(im);
        r.x += (int) Math.floor(x) - 2 + bounds.x;
        r.y += (int) Math.floor(y) - 2 + bounds.y;
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17214().computeLayoutBounds(tl, x, y, frc));
    }
}
