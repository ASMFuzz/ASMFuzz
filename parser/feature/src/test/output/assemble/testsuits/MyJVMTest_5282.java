import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_5282 {

    static Graphics2D g2d = null;

    static String fontParam1Param1Param1Param1 = "l1zO,Pf?-.";

    static int fontParam1Param1Param1Param2 = 438;

    static int fontParam1Param1Param1Param3 = 190;

    static Font fontParam1Param1Param1 = new Font(fontParam1Param1Param1Param1, fontParam1Param1Param1Param2, fontParam1Param1Param1Param3);

    static Font fontParam1Param1 = new Font(fontParam1Param1Param1);

    static Font fontParam1 = new Font(fontParam1Param1);

    static Font font = new Font(fontParam1);

    static float ypos = Float.NEGATIVE_INFINITY;

    static String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890";

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5282().drawText(g2d, font, ypos));
    }
}
