import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.*;
import java.io.*;

public class MyJVMTest_9477 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 6;

    static Button print2D = new Button("2D Print");

    static Button printMerlin = new Button("PrintService");

    static PrinterJob pj = PrinterJob.getPrinterJob();

    static PrintService defService = null;

    static HashPrintRequestAttributeSet prSet = new HashPrintRequestAttributeSet();

    int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        g.drawString("Page: " + pageIndex, 100, 100);
        if (pageIndex == 2) {
            return Printable.NO_SUCH_PAGE;
        } else {
            return Printable.PAGE_EXISTS;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9477().print(g, pf, pageIndex));
    }
}
