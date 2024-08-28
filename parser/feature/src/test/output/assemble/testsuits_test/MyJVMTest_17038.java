import java.awt.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.print.*;

public class MyJVMTest_17038 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pi = 9;

    int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
        if (pi > 0) {
            System.out.println("pi is greater than 0");
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.translate(pf.getImageableX(), pf.getImageableY());
        g2.drawRect(1, 1, 200, 300);
        g2.drawRect(1, 1, 25, 25);
        System.out.println("print method called " + pi);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17038().print(g, pf, pi));
    }
}
