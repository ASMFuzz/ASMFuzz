import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_18081 {

    static Graphics g = new Graphics2D();

    static PageFormat pgFmt = new PageFormat();

    static int pgIndex = 405122995;

    float drawText(Graphics2D g2d, Font font, float ypos) {
        int x = 10;
        Font f1 = new Font("serif", Font.ITALIC, 1);
        g2d.setFont(f1);
        FontRenderContext frc = new FontRenderContext(null, false, false);
        TextLayout tl = new TextLayout(text, font, frc);
        float ascent = tl.getAscent();
        int dpos = (int) (ypos + ascent);
        tl.draw(g2d, x, dpos);
        int dpos2 = (int) (ypos + ascent + tl.getDescent());
        g2d.drawLine(x, dpos2, x + (int) tl.getAdvance(), dpos2);
        float tlHeight = tl.getAscent() + tl.getDescent() + tl.getLeading();
        return ypos + tlHeight;
    }

    static String[] fontnames = { "Lucida Sans", "Lucida Bright", "Lucida Sans Typewriter", "SansSerif", "Serif", "Monospaced" };

    static String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";

    int print(Graphics g, PageFormat pgFmt, int pgIndex) {
        if (pgIndex > 0)
            return Printable.NO_SUCH_PAGE;
        double iw = pgFmt.getImageableWidth();
        double ih = pgFmt.getImageableHeight();
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pgFmt.getImageableX(), pgFmt.getImageableY() + 50);
        float ypos = 20f;
        for (int f = 0; f < fontnames.length; f++) {
            for (int s = 0; s < 4; s++) {
                Font font = new Font(fontnames[f], s, 12);
                ypos = drawText(g2d, font, ypos);
            }
        }
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18081().print(g, pgFmt, pgIndex));
    }
}
