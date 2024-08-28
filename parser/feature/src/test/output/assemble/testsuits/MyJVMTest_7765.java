import java.util.*;
import java.text.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.renderable.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class MyJVMTest_7765 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int imageParam1 = 391;

    static int imageParam2 = 672;

    static int imageParam3 = 221;

    static int imageParam4Param1 = 631;

    static int imageParam4Param2 = 106;

    static int[] imageParam4Param3 = { -1259292694, 489973414, 0, -390843574, -836761542, 0, 2, 684418693, 5, 9 };

    static int imageParam4Param4 = 705;

    static boolean imageParam4Param5 = true;

    static int imageParam4Param6 = 579;

    static int imageParam4Param7 = 109;

    static IndexColorModel imageParam4 = new IndexColorModel(imageParam4Param1, imageParam4Param2, imageParam4Param3, imageParam4Param4, imageParam4Param5, imageParam4Param6, imageParam4Param7);

    static BufferedImage image = new BufferedImage(imageParam1, imageParam2, imageParam3, imageParam4);

    static int _objectBorder = 15;

    static BufferedImage _image = null;

    static PageFormat _pageFormat = null;

    int printImage(Graphics g, PageFormat pf, BufferedImage image) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.transform(new AffineTransform(_pageFormat.getMatrix()));
        int paperW = (int) pf.getImageableWidth(), paperH = (int) pf.getImageableHeight();
        int x = (int) pf.getImageableX(), y = (int) pf.getImageableY();
        g2D.setClip(x, y, paperW, paperH);
        if (image != null) {
            int imageH = image.getHeight(), imageW = image.getWidth();
            float scaleFactor = ((float) ((paperW - 25) - _objectBorder - _objectBorder) / (float) (imageW));
            int scaledW = (int) (imageW * scaleFactor), scaledH = (int) (imageH * scaleFactor);
            BufferedImageOp scaleOp = new RescaleOp(scaleFactor, 0, null);
            g2D.drawImage(image, scaleOp, x + _objectBorder, y + _objectBorder);
            y += _objectBorder + scaledH + _objectBorder;
            return Printable.PAGE_EXISTS;
        } else {
            return Printable.NO_SUCH_PAGE;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7765().printImage(g, pf, image));
    }
}
