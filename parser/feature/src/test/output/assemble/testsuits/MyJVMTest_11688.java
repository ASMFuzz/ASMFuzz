import java.awt.*;
import java.awt.print.*;

public class MyJVMTest_11688 {

    static Graphics g = new Graphics2D();

    static PageFormat pgFmt = new PageFormat();

    static int pgIndex = 5;

    static String theName = "Testing the Jobname setting";

    int print(Graphics g, PageFormat pgFmt, int pgIndex) {
        if (pgIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        double iw = pgFmt.getImageableWidth();
        double ih = pgFmt.getImageableHeight();
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pgFmt.getImageableX(), pgFmt.getImageableY());
        g2d.drawString("Name is: " + theName, 20, 20);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11688().print(g, pgFmt, pgIndex));
    }
}
