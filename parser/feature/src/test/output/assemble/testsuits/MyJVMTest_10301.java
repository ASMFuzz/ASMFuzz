import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_10301 {

    static int w = 8;

    static int h = 6;

    static Polygon poly = null;

    static GeneralPath path = null;

    static ImageCanvas unclipped = null;

    static ImageCanvas reference = null;

    static ImageCanvas actual = null;

    static ImageCanvas diff = null;

    static int rows = 0;

    static int cols = 6;

    static int hgap = 1;

    static int vgap = 0;

    static BufferedImage image = null;

    int checkImage(int w, int h) {
        if (image == null || image.getWidth() < w || image.getHeight() < h) {
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }
        return h;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10301().checkImage(w, h);
    }
}
