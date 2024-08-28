import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_11570 {

    static int rgb1 = 3;

    static int rgb2 = 0;

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 0;

    static int cols = 0;

    static int hgap = 6;

    static int vgap = 0;

    int maxdiff(int rgb1, int rgb2) {
        int maxd = 0;
        for (int i = 0; i < 32; i += 8) {
            int c1 = (rgb1 >> i) & 0xff;
            int c2 = (rgb2 >> i) & 0xff;
            int d = Math.abs(c1 - c2);
            if (maxd < d) {
                maxd = d;
            }
        }
        return maxd;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11570().maxdiff(rgb1, rgb2));
    }
}
