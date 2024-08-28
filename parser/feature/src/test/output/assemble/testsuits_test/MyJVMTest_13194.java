import java.io.*;
import java.awt.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class MyJVMTest_13194 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 0;

    int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 12));
        g.drawString("?", 100, 150);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13194().print(g, pf, pageIndex));
    }
}
