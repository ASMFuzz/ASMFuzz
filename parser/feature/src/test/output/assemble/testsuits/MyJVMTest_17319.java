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

public class MyJVMTest_17319 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int imageParam1 = 177;

    static int imageParam2 = 378;

    static int imageParam3 = 238;

    static BufferedImage image = new BufferedImage(imageParam1, imageParam2, imageParam3);

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
        System.out.println(new MyJVMTest_17319().printImage(g, pf, image));
    }
}
