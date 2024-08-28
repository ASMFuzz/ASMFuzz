import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class MyJVMTest_13295 {

    static Graphics g = new Graphics2D();

    Graphics paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.white);
        g.fillRect(0, 0, 400, 300);
        g.setColor(Color.black);
        Font origFont = new Font(Font.DIALOG, Font.BOLD, 30);
        for (int i = 0; i <= 360; i++) {
            double sv = i * 180.0 / Math.PI;
            AffineTransform tx = AffineTransform.getShearInstance(sv, sv);
            Font font = origFont.deriveFont(tx);
            g.setFont(font);
            GlyphVector gv = font.createGlyphVector(g2.getFontRenderContext(), "JavaFX");
            g.drawString("JavaFX", 100, 100);
        }
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13295().paint(g);
    }
}
