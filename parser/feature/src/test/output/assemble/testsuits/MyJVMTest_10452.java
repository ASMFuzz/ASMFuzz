import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_10452 {

    static Graphics graphics = new Graphics2D();

    static PageFormat pageFormat = new PageFormat();

    static int pageIndex = 7;

    static PrinterJob myPrinterJob = null;

    static PageFormat myPageFormat = null;

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
        g2d.setColor(Color.black);
        g2d.drawRect(1, 1, (int) pageFormat.getImageableWidth() - 2, (int) pageFormat.getImageableHeight() - 2);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10452().print(graphics, pageFormat, pageIndex));
    }
}
