import java.awt.*;
import java.awt.print.*;

public class MyJVMTest_11600 {

    static Graphics g = new Graphics2D();

    static PageFormat pagef = new PageFormat();

    static int pidx = 1;

    static PrinterJob pj = null;

    static boolean okayed = true;

    int print(Graphics g, PageFormat pagef, int pidx) {
        if (pidx > 5) {
            return (Printable.NO_SUCH_PAGE);
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pagef.getImageableX(), pagef.getImageableY());
        g2d.setColor(Color.black);
        g2d.drawString(("This is page" + (pidx + 1)), 60, 80);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return (Printable.PAGE_EXISTS);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11600().print(g, pagef, pidx));
    }
}
