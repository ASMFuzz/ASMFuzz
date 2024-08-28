import java.awt.geom.*;
import java.awt.print.*;
import java.awt.*;

public class MyJVMTest_16890 {

    static Graphics2D g = null;

    static PageFormat pf = new PageFormat();

    PageFormat drawGraphics(Graphics2D g, PageFormat pf) {
        double ix = pf.getImageableX();
        double iy = pf.getImageableY();
        double iw = pf.getImageableWidth();
        double ih = pf.getImageableHeight();
        g.setColor(Color.black);
        g.drawString(((pf.getOrientation() == PageFormat.PORTRAIT) ? "Portrait" : "Landscape"), (int) (ix + iw / 2), (int) (iy + ih / 2));
        g.draw(new Ellipse2D.Double(ix, iy, iw, ih));
        return pf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16890().drawGraphics(g, pf);
    }
}
