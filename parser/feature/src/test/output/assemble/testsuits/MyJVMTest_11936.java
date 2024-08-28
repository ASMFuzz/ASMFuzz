import java.awt.*;
import java.awt.geom.*;

public class MyJVMTest_11936 {

    static Graphics g = new Graphics2D();

    static String text = "This test passes only if this text appears SIX TIMES";

    Graphics2D test2(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.setColor(Color.black);
        g2d.drawString(text, 10, 50);
        g2d.setPaint(new GradientPaint(0f, 0f, Color.BLACK, 100f, 100f, Color.GRAY));
        g2d.drawString(text, 10, 80);
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11936().test2(g);
    }
}
