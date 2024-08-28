import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.text.*;

public class MyJVMTest_11138 {

    static Graphics g1 = new Graphics2D();

    int paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        Font f = new Font("Dialog", Font.PLAIN, 20);
        int tx = 20;
        int ty = 20;
        AffineTransform at = AffineTransform.getTranslateInstance(tx, ty);
        f = f.deriveFont(at);
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        String str = "Basic ascii string";
        int sw = fm.stringWidth(str);
        int posx = 20, posy = 40;
        g.drawString(str, posx, posy);
        g.drawLine(posx + tx, posy + ty + 2, posx + tx + sw, posy + ty + 2);
        posx = 20;
        posy = 70;
        str = "Test string compound printing \u2203\u2200";
        sw = fm.stringWidth(str);
        g.drawString(str, posx, posy);
        g.drawLine(posx + tx, posy + ty + 2, posx + tx + sw, posy + ty + 2);
        return posy;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11138().paint(g1);
    }
}
