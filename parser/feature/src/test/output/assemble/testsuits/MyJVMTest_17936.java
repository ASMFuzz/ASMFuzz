import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_17936 {

    static Graphics2D g2d = null;

    BufferedImage makeSourceImage(int size, int type) {
        int s2 = size / 2;
        BufferedImage img = new BufferedImage(size, size, type);
        Graphics2D g2d = img.createGraphics();
        g2d.setComposite(AlphaComposite.Src);
        g2d.setColor(Color.orange);
        g2d.fillRect(0, 0, size, size);
        g2d.setColor(Color.red);
        g2d.fillRect(0, 0, s2, s2);
        g2d.setColor(Color.green);
        g2d.fillRect(s2, 0, s2, s2);
        g2d.setColor(Color.blue);
        g2d.fillRect(0, s2, s2, s2);
        g2d.setColor(new Color(255, 255, 0, 128));
        g2d.fillRect(s2, s2, s2, s2);
        g2d.setColor(Color.pink);
        g2d.fillOval(s2 - 3, s2 - 3, 6, 6);
        g2d.dispose();
        return img;
    }

    static int TESTW = 600;

    static int TESTH = 500;

    static boolean ignore = true;

    static int[] srcSizes = { 32, 17 };

    static int[] srcTypes = { BufferedImage.TYPE_INT_RGB, BufferedImage.TYPE_INT_ARGB, BufferedImage.TYPE_INT_ARGB_PRE, BufferedImage.TYPE_INT_BGR, BufferedImage.TYPE_3BYTE_BGR, BufferedImage.TYPE_4BYTE_ABGR, BufferedImage.TYPE_USHORT_565_RGB, BufferedImage.TYPE_BYTE_GRAY, BufferedImage.TYPE_USHORT_GRAY };

    static RescaleOp rescale1band = null, rescale3band = null, rescale4band = null;

    static LookupOp lookup1bandbyte = null, lookup3bandbyte = null, lookup4bandbyte = null;

    static LookupOp lookup1bandshort = null, lookup3bandshort = null, lookup4bandshort = null;

    static ConvolveOp convolve3x3zero = null, convolve5x5zero = null, convolve7x7zero = null;

    static ConvolveOp convolve3x3noop = null, convolve5x5noop = null, convolve7x7noop = null;

    int renderTest(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, TESTW, TESTH);
        int yorig = 2;
        int xinc = 34;
        int yinc = srcSizes[0] + srcSizes[1] + 2 + 2;
        for (int srcType : srcTypes) {
            int y = yorig;
            for (int srcSize : srcSizes) {
                int x = 2;
                System.out.printf("type=%d size=%d\n", srcType, srcSize);
                BufferedImage srcImg = makeSourceImage(srcSize, srcType);
                ColorModel srcCM = srcImg.getColorModel();
                g2d.drawImage(srcImg, rescale1band, x, y);
                x += xinc;
                if (srcCM.getNumColorComponents() == 3 && !(ignore && srcCM.hasAlpha())) {
                    g2d.drawImage(srcImg, rescale3band, x, y);
                }
                x += xinc;
                if (srcCM.getNumComponents() == 4) {
                    g2d.drawImage(srcImg, rescale4band, x, y);
                }
                x += xinc;
                if (srcType != BufferedImage.TYPE_USHORT_GRAY) {
                    g2d.drawImage(srcImg, lookup1bandbyte, x, y);
                    x += xinc;
                    if (srcCM.getNumColorComponents() == 3) {
                        g2d.drawImage(srcImg, lookup3bandbyte, x, y);
                    }
                    x += xinc;
                    if (srcCM.getNumComponents() == 4) {
                        g2d.drawImage(srcImg, lookup4bandbyte, x, y);
                    }
                    x += xinc;
                    if (!(ignore && (srcType == BufferedImage.TYPE_3BYTE_BGR || srcType == BufferedImage.TYPE_4BYTE_ABGR))) {
                        g2d.drawImage(srcImg, lookup1bandshort, x, y);
                        x += xinc;
                        if (srcCM.getNumColorComponents() == 3 && !(ignore && srcCM.hasAlpha())) {
                            g2d.drawImage(srcImg, lookup3bandshort, x, y);
                        }
                        x += xinc;
                        if (srcCM.getNumComponents() == 4) {
                            g2d.drawImage(srcImg, lookup4bandshort, x, y);
                        }
                        x += xinc;
                    } else {
                        x += 3 * xinc;
                    }
                } else {
                    x += 6 * xinc;
                }
                if (srcType != BufferedImage.TYPE_3BYTE_BGR) {
                    g2d.drawImage(srcImg, convolve3x3zero, x, y);
                    x += xinc;
                    g2d.drawImage(srcImg, convolve5x5zero, x, y);
                    x += xinc;
                    g2d.drawImage(srcImg, convolve7x7zero, x, y);
                    x += xinc;
                    g2d.drawImage(srcImg, convolve3x3noop, x, y);
                    x += xinc;
                    g2d.drawImage(srcImg, convolve5x5noop, x, y);
                    x += xinc;
                    g2d.drawImage(srcImg, convolve7x7noop, x, y);
                    x += xinc;
                } else {
                    x += 6 * xinc;
                }
                y += srcSize + 2;
            }
            yorig += yinc;
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17936().renderTest(g2d);
    }
}
