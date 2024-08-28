import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.text.*;

public class MyJVMTest_7218 {

    static Graphics g = new Graphics2D();

    static PageFormat pgFmt = new PageFormat();

    static int pgIndex = 2;

    void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        String str = "Test string compound printing \u2203\u2200\u2211";
        g.drawString(str, 20, 40);
    }

    int print(Graphics g, PageFormat pgFmt, int pgIndex) {
        if (pgIndex > 0)
            return Printable.NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pgFmt.getImageableX(), pgFmt.getImageableY());
        paint(g);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7218().print(g, pgFmt, pgIndex));
    }
}
