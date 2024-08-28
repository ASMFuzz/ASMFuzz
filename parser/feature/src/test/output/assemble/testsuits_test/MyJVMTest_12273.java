import java.awt.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.awt.print.*;
import java.io.*;

public class MyJVMTest_12273 {

    static Graphics g = new Graphics2D();

    static PageFormat pg = new PageFormat();

    static int pageIndex = 5;

    int print(Graphics g, PageFormat pg, int pageIndex) {
        Graphics2D g2d = (Graphics2D) g;
        if (pageIndex > 2) {
            return Printable.NO_SUCH_PAGE;
        } else {
            g2d.translate(pg.getImageableX(), pg.getImageableY());
            g2d.setColor(Color.RED);
            g2d.drawString("page " + pageIndex, 100, 100);
            return Printable.PAGE_EXISTS;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12273().print(g, pg, pageIndex));
    }
}
