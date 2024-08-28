import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class MyJVMTest_15323 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 5;

    int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        g.setColor(Color.black);
        int[] xq = { 75, 125, 75 };
        int[] yq = { 140, 140, 140 };
        g.fillPolygon(xq, yq, 3);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15323().print(g, pf, pageIndex));
    }
}
