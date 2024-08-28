import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_13823 {

    static Graphics graphics = new Graphics2D();

    static PageFormat pageFormat = new PageFormat();

    static int pageIndex = 5;

    static PrinterJob pJob = null;

    static PageFormat pf = null;

    int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 1) {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.drawString("ORIGIN", 30, 30);
        g2d.drawString("X THIS WAY", 200, 50);
        g2d.drawString("Y THIS WAY", 60, 200);
        g2d.drawRect(0, 0, (int) pageFormat.getImageableWidth(), (int) pageFormat.getImageableHeight());
        if (pageIndex == 0) {
            g2d.setColor(Color.black);
        } else {
            g2d.setColor(new Color(0, 0, 0, 128));
        }
        g2d.drawRect(1, 1, (int) pageFormat.getImageableWidth() - 2, (int) pageFormat.getImageableHeight() - 2);
        g2d.drawLine(0, 0, (int) pageFormat.getImageableWidth(), (int) pageFormat.getImageableHeight());
        g2d.drawLine((int) pageFormat.getImageableWidth(), 0, 0, (int) pageFormat.getImageableHeight());
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13823().print(graphics, pageFormat, pageIndex));
    }
}
