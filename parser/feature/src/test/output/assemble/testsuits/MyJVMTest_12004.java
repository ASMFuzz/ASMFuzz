import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;

public class MyJVMTest_12004 {

    static Graphics g = new Graphics2D();

    Rectangle2D drawGVs(Graphics g) {
        String testString = "0123456789abcdefghijklm";
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        Font font = new Font("SansSerif", Font.PLAIN, 30);
        FontRenderContext frc = g2d.getFontRenderContext();
        GlyphVector v = font.createGlyphVector(frc, testString);
        float x = 50f, y = 50f;
        g2d.drawGlyphVector(v, x, y);
        Rectangle2D r = v.getVisualBounds();
        r.setRect(r.getX() + x, r.getY() + y, r.getWidth(), r.getHeight());
        g2d.draw(r);
        Point2D p;
        for (int i = 0; i < v.getNumGlyphs(); i++) {
            p = v.getGlyphPosition(i);
            p.setLocation(p.getX() + 50, p.getY());
            v.setGlyphPosition(i, p);
        }
        x = 0;
        y += 50;
        g2d.drawGlyphVector(v, x, y);
        r = v.getVisualBounds();
        r.setRect(r.getX() + x, r.getY() + y, r.getWidth(), r.getHeight());
        g2d.draw(r);
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12004().drawGVs(g);
    }
}
