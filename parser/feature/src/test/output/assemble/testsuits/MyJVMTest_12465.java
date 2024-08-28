import java.awt.*;
import java.awt.print.*;
import java.awt.event.*;

public class MyJVMTest_12465 {

    static Graphics g = new Graphics2D();

    static PrintImage pdsFrame = null;

    Graphics paint(Graphics g) {
        Font drawFont = new Font("MS Mincho", Font.ITALIC, 50);
        g.setFont(drawFont);
        g.drawString("PrintSample!", 100, 150);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12465().paint(g);
    }
}
