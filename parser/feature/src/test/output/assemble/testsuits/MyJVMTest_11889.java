import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_11889 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 0;

    static boolean firstTime = true;

    static double sx = Double.MAX_VALUE, sy = 0d;

    static Shape clip = null, firstClip = null;

    int print(Graphics g, PageFormat pf, int pageIndex) {
        Graphics2D g2 = (Graphics2D) g;
        if (pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        AffineTransform at = g2.getTransform();
        System.out.println(at);
        clip = g2.getClip();
        System.out.println(clip);
        if (firstTime) {
            firstTime = false;
            sx = Math.abs(at.getScaleX());
            sy = Math.abs(at.getScaleY());
            firstClip = clip;
        } else {
            double newSx = Math.abs(at.getScaleX());
            double newSy = Math.abs(at.getScaleY());
            if (Math.abs(sx - newSx) > 0.1 || Math.abs(sy - newSy) > 0.1) {
                throw new RuntimeException("different scale, was " + sx + "," + sy + " now " + newSx + "," + newSy);
            }
            if (!clip.equals(firstClip)) {
                throw new RuntimeException("different clip, was " + firstClip + " now " + clip);
            }
        }
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11889().print(g, pf, pageIndex));
    }
}
