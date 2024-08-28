import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_16976 {

    static Graphics2D g2d = null;

    static int TESTWIDTH = 1554741346;

    static int TESTHEIGHT = 5;

    static boolean forceerror = true;

    static boolean fulltest = true;

    static int[][][] polypts = { { {}, {} }, { { 0 }, { 0 } }, { { 0, 5 }, { 0, 0 }, { 0, 0, 6, 1, 10, 0, 6, 1, 20, 0, 6, 1 }, { 0, 0, 6, 1, 10, 0, 1, 1, 15, 0, 1, 1, 20, 0, 1, 1, 25, 0, 1, 1 }, { 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 5, 5 }, { 0, 0, 5 }, { 0, 0, 6, 1, 5, 1, 1, 5, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 0, 0, 6, 1, 5, 1, 1, 5, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 5, 5, 0 }, { 0, 0, 5, 0 }, { 0, 0, 6, 1, 5, 1, 1, 5, 1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 4, 4, 1, 1, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 1, 0, 5, 1, 5, 1, 1, 5, 1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 4, 4, 1, 1, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 0 }, { 0, 0 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } } };

    static BufferedImage bimg = null;

    Graphics2D render(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, TESTWIDTH, TESTHEIGHT);
        g2d.setColor(Color.black);
        if (forceerror) {
            g2d.fillRect(2, 2, 2, 2);
            g2d.fillRect(15, 5, 1, 1);
        }
        if (!fulltest) {
            g2d.draw(new Rectangle2D.Double(5, 5, 0, 0));
            return;
        }
        g2d.drawLine(10, 10, 10, 10);
        g2d.draw(new Line2D.Double(20, 10, 20, 10));
        g2d.drawRect(10, 20, 0, 0);
        g2d.draw(new Rectangle2D.Double(20, 20, 0, 0));
        g2d.setXORMode(Color.white);
        g2d.drawLine(10, 30, 10, 30);
        g2d.draw(new Line2D.Double(20, 30, 20, 30));
        g2d.drawRect(10, 40, 0, 0);
        g2d.draw(new Rectangle2D.Double(20, 40, 0, 0));
        g2d.setPaintMode();
        int y = 50;
        for (int i = 0; i < polypts.length; i++) {
            int[][] data = polypts[i];
            int[] xpoints = data[0];
            int[] ypoints = data[1];
            int npoints = xpoints.length;
            g2d.translate(10, y);
            g2d.drawPolyline(xpoints, ypoints, npoints);
            g2d.translate(10, 0);
            g2d.drawPolygon(xpoints, ypoints, npoints);
            g2d.translate(10, 0);
            g2d.draw(new Polygon(xpoints, ypoints, npoints));
            g2d.translate(-30, -y);
            y += 10;
        }
        g2d.setXORMode(Color.white);
        for (int i = 0; i < polypts.length; i++) {
            int[][] data = polypts[i];
            int[] xpoints = data[0];
            int[] ypoints = data[1];
            int npoints = xpoints.length;
            g2d.translate(10, y);
            g2d.drawPolyline(xpoints, ypoints, npoints);
            g2d.translate(10, 0);
            g2d.drawPolygon(xpoints, ypoints, npoints);
            g2d.translate(10, 0);
            g2d.draw(new Polygon(xpoints, ypoints, npoints));
            g2d.translate(-30, -y);
            y += 10;
        }
        g2d.setPaintMode();
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16976().render(g2d);
    }
}
