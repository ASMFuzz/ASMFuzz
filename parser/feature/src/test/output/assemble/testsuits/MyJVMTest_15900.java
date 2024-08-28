import java.awt.*;
import java.awt.print.*;
import javax.print.*;

public class MyJVMTest_15900 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 0;

    static PrinterJob pj = null;

    int print(Graphics g, PageFormat pf, int pageIndex) {
        Graphics2D g2 = (Graphics2D) g;
        if (pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        g2.translate(pf.getImageableX(), pf.getImageableY());
        g2.setColor(Color.black);
        g2.drawString("Hello world.", 10, 10);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15900().print(g, pf, pageIndex));
    }
}
