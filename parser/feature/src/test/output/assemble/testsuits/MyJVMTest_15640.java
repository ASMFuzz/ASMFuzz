import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_15640 {

    static Graphics g = new Graphics2D();

    static PageFormat pgFmt = new PageFormat();

    static int pgIndex = 5;

    void printScale(Graphics2D g2D, Font font, float scale, float x, float y) {
        int RES = 72;
        g2D.scale(scale, scale);
        g2D.setFont(font.deriveFont(10.0f / scale));
        g2D.drawString("This text is scaled by a factor of " + scale, x * RES / scale, y * RES / scale);
        g2D.scale(1 / scale, 1 / scale);
    }

    int print(Graphics g, PageFormat pgFmt, int pgIndex) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.translate(pgFmt.getImageableX(), pgFmt.getImageableY());
        g2D.setColor(Color.black);
        Font font = new Font("serif", Font.PLAIN, 1);
        float scale;
        float x;
        float y;
        scale = 1.0f;
        x = 3.0f;
        y = 3.0f;
        printScale(g2D, font, scale, x, y);
        scale = 2.0f;
        x = 3.0f;
        y = 3.5f;
        printScale(g2D, font, scale, x, y);
        scale = 4.0f;
        x = 3.0f;
        y = 4.0f;
        printScale(g2D, font, scale, x, y);
        scale = 8.0f;
        x = 3.0f;
        y = 4.5f;
        printScale(g2D, font, scale, x, y);
        scale = 16.0f;
        x = 3.0f;
        y = 5.0f;
        printScale(g2D, font, scale, x, y);
        scale = 32.0f;
        x = 3.0f;
        y = 5.5f;
        printScale(g2D, font, scale, x, y);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15640().print(g, pgFmt, pgIndex));
    }
}
