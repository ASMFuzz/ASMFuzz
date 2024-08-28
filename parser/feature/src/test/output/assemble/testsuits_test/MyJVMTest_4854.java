import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_4854 {

    static int X = 1;

    static int Y = 0;

    static int fuzzystarty = 0;

    static boolean fulltest = true;

    static int[][][] polypts = { { {}, {} }, { { 0 }, { 0 } }, { { 0, 5 }, { 0, 0 }, { 0, 0, 6, 1, 10, 0, 6, 1, 20, 0, 6, 1 }, { 0, 0, 6, 1, 10, 0, 1, 1, 15, 0, 1, 1, 20, 0, 1, 1, 25, 0, 1, 1 }, { 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 5, 5 }, { 0, 0, 5 }, { 0, 0, 6, 1, 5, 1, 1, 5, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 0, 0, 6, 1, 5, 1, 1, 5, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 5, 5, 0 }, { 0, 0, 5, 0 }, { 0, 0, 6, 1, 5, 1, 1, 5, 1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 4, 4, 1, 1, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 1, 0, 5, 1, 5, 1, 1, 5, 1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 1, 1, 4, 4, 1, 1, 10, 0, 6, 1, 15, 1, 1, 5, 11, 1, 1, 1, 12, 2, 1, 1, 13, 3, 1, 1, 14, 4, 1, 1, 20, 0, 6, 1, 25, 1, 1, 5, 21, 1, 1, 1, 22, 2, 1, 1, 23, 3, 1, 1, 24, 4, 1, 1 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 0 }, { 0, 0 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } }, { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1, 1, 10, 0, 1, 1, 20, 0, 1, 1 } } };

    static BufferedImage bimg = null;

    boolean isFuzzyPixel(int X, int Y) {
        int ytrans = fuzzystarty;
        if (!fulltest || Y < ytrans) {
            return false;
        }
        for (int i = 0; i < polypts.length; i++) {
            int[][] data = polypts[i];
            if (data.length > 4) {
                int[] rectvals = data[4];
                for (int j = 0; j < rectvals.length; j += 4) {
                    int rectx = rectvals[j + 0] + 10;
                    int recty = rectvals[j + 1] + ytrans;
                    int rectw = rectvals[j + 2];
                    int recth = rectvals[j + 3];
                    if (X >= rectx && Y >= recty && X < rectx + rectw && Y < recty + recth) {
                        return true;
                    }
                }
            }
            ytrans += 10;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4854().isFuzzyPixel(X, Y));
    }
}
