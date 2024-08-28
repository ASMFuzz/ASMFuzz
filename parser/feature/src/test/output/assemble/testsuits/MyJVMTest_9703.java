import java.awt.*;
import java.awt.print.*;
import javax.print.*;

public class MyJVMTest_9703 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pi = -1025062671;

    int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.translate(pf.getImageableX(), pf.getImageableY());
        g2.drawRect(1, 1, 200, 300);
        g2.drawRect(1, 1, 25, 25);
        System.out.println("print method called " + pi + " Orientation " + pf.getOrientation());
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9703().print(g, pf, pi));
    }
}
