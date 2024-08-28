import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_2310 {

    static int rgb1 = 6;

    static int rgb2 = 0;

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 0;

    static int cols = 9;

    static int hgap = 9;

    static int vgap = 1;

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
        System.out.println(new MyJVMTest_2310().maxdiff(rgb1, rgb2));
    }
}
