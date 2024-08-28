import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_1106 {

    static int w = 0;

    static int h = 0;

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 6;

    static int cols = 0;

    static int hgap = 6;

    static int vgap = 2;

    static BufferedImage image = null;

    int checkImage(int w, int h) {
        if (image == null || image.getWidth() < w || image.getHeight() < h) {
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }
        return h;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1106().checkImage(w, h);
    }
}
