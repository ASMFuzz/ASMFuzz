import java.awt.*;
import java.awt.geom.*;

public class MyJVMTest_12445 {

    static Graphics g = new Graphics2D();

    static String text = "This test passes only if this text appears SIX TIMES";

    Graphics2D test1(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.setColor(Color.black);
        g2d.drawString(text, 10, 50);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2d.drawString(text, 10, 80);
        return g2d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12445().test1(g);
    }
}
