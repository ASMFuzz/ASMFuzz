import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.print.*;

public class MyJVMTest_17696 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 1;

    void drawGraphics(Graphics2D g, PageFormat pf) {
        double iw = pf.getImageableWidth();
        double ih = pf.getImageableHeight();
        g.setColor(Color.black);
        String orientation;
        switch(pf.getOrientation()) {
            case PageFormat.PORTRAIT:
                orientation = "PORTRAIT";
                break;
            case PageFormat.LANDSCAPE:
                orientation = "LANDSCAPE";
                break;
            case PageFormat.REVERSE_LANDSCAPE:
                orientation = "REVERSE_LANDSCAPE";
                break;
            default:
                orientation = "INVALID";
        }
        g.drawString(orientation, 100, 300);
        g.draw(new Ellipse2D.Double(0, 0, iw, ih));
        g.drawString("(0,0)", 5, 15);
        g.drawLine(0, 0, 300, 0);
        g.drawString("X", 300, 15);
        g.drawLine(0, 0, 0, 300);
        g.drawString("Y", 5, 300);
    }

    int print(Graphics g, PageFormat pf, int pageIndex) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        drawGraphics(g2d, pf);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17696().print(g, pf, pageIndex));
    }
}
