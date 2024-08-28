import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_16907 {

    static int imgrefParam1 = 835;

    static int imgrefParam2 = 251;

    static int imgrefParam3 = 597;

    static int imgrefParam4Param1 = 522;

    static int imgrefParam4Param2 = 806;

    static byte[] imgrefParam4Param3 = { 63, 30, -58, -82, 121, 37, 114, -90, -52, 113 };

    static byte[] imgrefParam4Param4 = { -16, -50, -98, 111, -77, -88, -73, 96, -57, -48 };

    static byte[] imgrefParam4Param5 = { 95, -108, -16, 52, 97, -9, -75, -124, -84, -96 };

    static byte[] imgrefParam4Param6 = { -28, 90, -114, -21, 119, 66, -18, 1, -6, -106 };

    static IndexColorModel imgrefParam4 = new IndexColorModel(imgrefParam4Param1, imgrefParam4Param2, imgrefParam4Param3, imgrefParam4Param4, imgrefParam4Param5, imgrefParam4Param6);

    static BufferedImage imgref = new BufferedImage(imgrefParam1, imgrefParam2, imgrefParam3, imgrefParam4);

    static int imgtstParam1 = 659;

    static int imgtstParam2 = 740;

    static int imgtstParam3 = 431;

    static int imgtstParam4Param1 = 427;

    static int imgtstParam4Param2 = 98;

    static byte[] imgtstParam4Param3 = { 0, 102, -38, 100, -51, -37, -14, -71, 57, -32 };

    static int imgtstParam4Param4 = 317;

    static boolean imgtstParam4Param5 = true;

    static int imgtstParam4Param6 = 116;

    static IndexColorModel imgtstParam4 = new IndexColorModel(imgtstParam4Param1, imgtstParam4Param2, imgtstParam4Param3, imgtstParam4Param4, imgtstParam4Param5, imgtstParam4Param6);

    static BufferedImage imgtst = new BufferedImage(imgtstParam1, imgtstParam2, imgtstParam3, imgtstParam4);

    void checkImage(int w, int h) {
        if (image == null || image.getWidth() < w || image.getHeight() < h) {
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }
    }

    static BufferedImage image = null;

    Graphics setDiff(BufferedImage imgref, BufferedImage imgtst) {
        int w = Math.max(imgref.getWidth(), imgtst.getWidth());
        int h = Math.max(imgref.getHeight(), imgtst.getHeight());
        checkImage(w, h);
        Graphics g = image.createGraphics();
        g.drawImage(imgref, 0, 0, null);
        g.setXORMode(Color.white);
        g.drawImage(imgtst, 0, 0, null);
        g.setPaintMode();
        g.setColor(new Color(1f, 1f, 0f, 0.25f));
        g.fillRect(10, 10, 20, 20);
        g.setColor(new Color(1f, 0f, 0f, 0.25f));
        g.fillRect(0, 0, 30, 10);
        g.fillRect(30, 0, 10, 30);
        g.fillRect(10, 30, 30, 10);
        g.fillRect(0, 10, 10, 30);
        g.dispose();
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16907().setDiff(imgref, imgtst);
    }
}
