import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.print.*;
import javax.swing.*;

public class MyJVMTest_14582 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int page = 152392211;

    int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        System.out.println("Calling print");
        if (page == 0) {
            Graphics2D g2 = (Graphics2D) g;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.setColor(Color.black);
            g2.drawString("Hello World", 20, 100);
            return Printable.PAGE_EXISTS;
        }
        return Printable.NO_SUCH_PAGE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14582().print(g, pf, page));
    }
}
