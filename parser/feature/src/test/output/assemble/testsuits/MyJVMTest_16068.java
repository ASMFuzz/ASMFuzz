import java.awt.*;
import java.awt.font.*;
import javax.swing.*;

public class MyJVMTest_16068 {

    static Graphics g = new Graphics2D();

    static int w = 400, h = 250;

    static String str = null;

    static Font font = null;

    Graphics2D paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, w, h);
        g2d.setColor(Color.black);
        int y = 0;
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setFont(font);
        g2d.drawString(str, 10, 50);
        FontRenderContext frc = g2d.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, str);
        g2d.drawGlyphVector(gv, 10, 100);
        TextLayout tl = new TextLayout(str, font, frc);
        tl.draw(g2d, 10, 150);
        char[] ca = str.toCharArray();
        g2d.drawChars(ca, 0, ca.length, 10, 200);
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16068().paint(g);
    }
}
