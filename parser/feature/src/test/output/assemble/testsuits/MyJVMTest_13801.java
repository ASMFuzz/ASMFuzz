import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_13801 {

    static int TESTWIDTH = -916037075;

    static int TESTHEIGHT = 1601573617;

    static BufferedImage refImg = null;

    static int fuzzystarty = -1821283811;

    static boolean fulltest = true;

    static int[][][] polypts = { { {}, {} }, { { 0 }, { 0 } }, { { 0, 5 }, { 0, 0 }, { 0, 0, 6, 1, 10, 0, 6, 1, 20, 0, 6, 1 }, { 0, 0, 6, 1, 10, 0, 1, 1, 15, 0, 1, 1, 20, 0, 1, 1, 25, 0, 1, 1 }, { 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 5, 5 }, { 0, 0, 5 }, { 0, 0, 6, 1, 5, 1, 1, 5, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 0, 0, 6, 1, 5, 1, 1, 5, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 5, 5, 0 }, { 0, 0, 5, 0 }, { 0, 0, 6, 1, 5, 1, 1, 5, 1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 4, 4, 1, 1, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 1, 0, 5, 1, 5, 1, 1, 5, 1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 4, 4, 1, 1, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 0 }, { 0, 0 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } } };

    static BufferedImage bimg = null;

    void makeReferenceImage() {
        refImg = new BufferedImage(TESTWIDTH, TESTHEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = refImg.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, TESTWIDTH, TESTHEIGHT);
        g.setColor(Color.black);
        if (!fulltest) {
            g.fillRect(5, 5, 1, 1);
            g.dispose();
            return;
        }
        for (int y = 10; y < 50; y += 10) {
            g.fillRect(10, y, 1, 1);
            g.fillRect(20, y, 1, 1);
        }
        int y = 50;
        for (int i = 0; i < polypts.length; i++) {
            int[][] data = polypts[i];
            g.translate(10, y);
            if (data.length > 2) {
                int[] rectvals = data[2];
                for (int j = 0; j < rectvals.length; j += 4) {
                    g.fillRect(rectvals[j + 0], rectvals[j + 1], rectvals[j + 2], rectvals[j + 3]);
                }
            }
            g.translate(-10, -y);
            y += 10;
        }
        fuzzystarty = y;
        for (int i = 0; i < polypts.length; i++) {
            int[][] data = polypts[i];
            g.translate(10, y);
            if (data.length > 2) {
                int[] rectvals = data.length > 3 ? data[3] : data[2];
                for (int j = 0; j < rectvals.length; j += 4) {
                    g.fillRect(rectvals[j + 0], rectvals[j + 1], rectvals[j + 2], rectvals[j + 3]);
                }
            }
            g.translate(-10, -y);
            y += 10;
        }
        g.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13801().makeReferenceImage();
    }
}
