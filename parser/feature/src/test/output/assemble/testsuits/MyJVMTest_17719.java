import java.io.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.*;
import javax.print.attribute.*;

public class MyJVMTest_17719 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 6;

    static String testString = "0123456789";

    int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        g.setColor(Color.black);
        float x = (float) pf.getImageableX() + 20f, y = (float) pf.getImageableY() + 30f;
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("SansSerif", Font.PLAIN, 20);
        FontRenderContext frc = g2.getFontRenderContext();
        GlyphVector v = font.createGlyphVector(frc, testString);
        for (int i = 0; i <= v.getNumGlyphs(); i++) {
            Point2D.Float p = new Point2D.Float();
            p.x = i * 40f;
            p.y = 0;
            v.setGlyphPosition(i, p);
        }
        g2.drawGlyphVector(v, x, y);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17719().print(g, pf, pageIndex));
    }
}
