import java.awt.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;

public class MyJVMTest_15411 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pi = 0;

    int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
        if (pi > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.translate(pf.getImageableX(), pf.getImageableY());
        System.out.println("StreamPrinting Test Width " + pf.getWidth() + " Height " + pf.getHeight());
        g2.drawRect(1, 1, 200, 300);
        g2.drawRect(1, 1, 25, 25);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15411().print(g, pf, pi));
    }
}
