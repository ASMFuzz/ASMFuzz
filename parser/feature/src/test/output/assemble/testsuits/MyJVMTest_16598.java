import java.awt.geom.*;
import java.awt.print.*;
import java.awt.*;

public class MyJVMTest_16598 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 792599133;

    void drawGraphics(Graphics2D g, PageFormat pf) {
        double ix = pf.getImageableX();
        double iy = pf.getImageableY();
        double iw = pf.getImageableWidth();
        double ih = pf.getImageableHeight();
        g.setColor(Color.black);
        g.drawString(((pf.getOrientation() == PageFormat.PORTRAIT) ? "Portrait" : "Landscape"), (int) (ix + iw / 2), (int) (iy + ih / 2));
        g.draw(new Ellipse2D.Double(ix, iy, iw, ih));
    }

    int print(Graphics g, PageFormat pf, int pageIndex) {
        Graphics2D g2d = (Graphics2D) g;
        drawGraphics(g2d, pf);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16598().print(g, pf, pageIndex));
    }
}
