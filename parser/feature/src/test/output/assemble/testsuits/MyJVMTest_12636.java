import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_12636 {

    static Graphics graphics = new Graphics2D();

    static PageFormat pageFormat = new PageFormat();

    static int pageIndex = 0;

    static PrinterJob myPrinterJob = null;

    static PageFormat myPageFormat = null;

    static Label pw = null, ph = null, pglm = null, pgrm = null, pgiw = null, pgih = null, pgtm = null, pgbm = null;

    static TextField tpw = null, tph = null, tpglm = null, tpgtm = null, tpgiw = null, tpgih = null;

    static Label myWidthLabel = null;

    static Label myHeightLabel = null;

    static Label myImageableXLabel = null;

    static Label myImageableYLabel = null;

    static Label myImageableRightLabel = null;

    static Label myImageableBottomLabel = null;

    static Label myImageableWidthLabel = null;

    static Label myImageableHeightLabel = null;

    static Label myOrientationLabel = null;

    int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        int o = pageFormat.getOrientation();
        System.out.println("Format Orientation = " + (o == PageFormat.PORTRAIT ? "PORTRAIT" : o == PageFormat.LANDSCAPE ? "LANDSCAPE" : o == PageFormat.REVERSE_LANDSCAPE ? "REVERSE_LANDSCAPE" : "<invalid>"));
        System.out.println(g2d.getTransform());
        System.out.println("ix=" + pageFormat.getImageableX() + " iy=" + pageFormat.getImageableY());
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.drawString("ORIGIN", 20, 20);
        g2d.drawString("X THIS WAY", 200, 50);
        g2d.drawString("Y THIS WAY", 60, 200);
        g2d.drawRect(0, 0, (int) pageFormat.getImageableWidth(), (int) pageFormat.getImageableHeight());
        g2d.setColor(Color.blue);
        g2d.drawRect(1, 1, (int) pageFormat.getImageableWidth() - 2, (int) pageFormat.getImageableHeight() - 2);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12636().print(graphics, pageFormat, pageIndex));
    }
}
