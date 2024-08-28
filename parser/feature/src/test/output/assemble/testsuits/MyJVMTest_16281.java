import java.awt.*;
import javax.swing.*;
import java.awt.print.*;

public class MyJVMTest_16281 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 522483856;

    static JFrame frame = null;

    int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        g.translate((int) pf.getImageableX(), (int) pf.getImageableY());
        frame.printAll(g);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16281().print(g, pf, pageIndex));
    }
}
