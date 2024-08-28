import java.awt.*;
import java.awt.print.*;

public class MyJVMTest_12823 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 0;

    static Font fnt = new Font("Helvetica", Font.PLAIN, 24);

    int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        g.setFont(fnt);
        g.setColor(Color.green);
        g.drawString("Page " + (pageIndex + 1), 100, 100);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12823().print(g, pf, pageIndex));
    }
}
