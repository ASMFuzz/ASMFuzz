import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class MyJVMTest_13613 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 7;

    int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        GeneralPath path1 = new GeneralPath(PathIterator.WIND_EVEN_ODD);
        GeneralPath path2 = new GeneralPath(PathIterator.WIND_EVEN_ODD);
        GeneralPath path3 = new GeneralPath(PathIterator.WIND_EVEN_ODD);
        path1.append(new Ellipse2D.Double(100, 100, 100, 100), false);
        path1.append(new Ellipse2D.Double(120, 120, 60, 60), false);
        path1.append(new Ellipse2D.Double(140, 140, 20, 20), false);
        path2.append(new Ellipse2D.Double(150, 100, 100, 100), false);
        path2.append(new Ellipse2D.Double(170, 120, 60, 60), false);
        path2.append(new Ellipse2D.Double(190, 140, 20, 20), false);
        path3.append(new Ellipse2D.Double(-50, -50, 100, 100), false);
        path3.append(new Ellipse2D.Double(-30, -30, 60, 60), false);
        path3.append(new Ellipse2D.Double(-10, -10, 20, 20), false);
        Rectangle clip = new Rectangle();
        g2.getClipBounds(clip);
        g2.setColor(Color.white);
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
        g2.setColor(Color.red);
        g2.fill(path1);
        g2.setColor(Color.black);
        g2.fill(path2);
        g2.translate(150, 400);
        g2.setColor(Color.red);
        g2.fill(path3);
        g2.translate(50, 0);
        g2.setColor(Color.black);
        g2.fill(path3);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13613().print(g, pf, pageIndex));
    }
}
