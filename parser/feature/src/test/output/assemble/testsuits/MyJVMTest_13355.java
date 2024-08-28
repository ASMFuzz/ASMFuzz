import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_13355 {

    static Graphics graphics = new Graphics2D();

    static PageFormat pageFormat = new PageFormat();

    static int pageIndex = 326551535;

    static PrinterJob myPrinterJob = null;

    static PageFormat myPageFormat = null;

    static Label pw = null, ph = null, pglm = null, pgiw = null, pgrm = null, pgtm = null, pgih = null, pgbm = null;

    static Label myWidthLabel = null;

    static Label myHeightLabel = null;

    static Label myImageableXLabel = null;

    static Label myImageableYLabel = null;

    static Label myImageableRightLabel = null;

    static Label myImageableBottomLabel = null;

    static Label myImageableWidthLabel = null;

    static Label myImageableHeightLabel = null;

    static Label myOrientationLabel = null;

    static Checkbox reverseCB = null;

    static boolean alpha = false;

    static boolean reverse = false;

    int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.drawString("ORIGIN(" + pageFormat.getImageableX() + "," + pageFormat.getImageableY() + ")", 20, 20);
        g2d.drawString("X THIS WAY", 200, 50);
        g2d.drawString("Y THIS WAY", 60, 200);
        g2d.drawString("Graphics is " + g2d.getClass().getName(), 100, 100);
        g2d.drawRect(0, 0, (int) pageFormat.getImageableWidth(), (int) pageFormat.getImageableHeight());
        if (alpha) {
            g2d.setColor(new Color(0, 0, 255, 192));
        } else {
            g2d.setColor(Color.blue);
        }
        g2d.drawRect(1, 1, (int) pageFormat.getImageableWidth() - 2, (int) pageFormat.getImageableHeight() - 2);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13355().print(graphics, pageFormat, pageIndex));
    }
}
