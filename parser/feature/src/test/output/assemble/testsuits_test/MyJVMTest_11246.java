import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11246 {

    static Graphics g = new Graphics2D();

    Graphics paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(0, 0, 399, 0);
        g.setColor(Color.RED);
        g.drawLine(0, 1, 399, 1);
        g.setColor(Color.BLUE);
        g.drawLine(0, 2, 399, 2);
        g.setColor(Color.GREEN);
        g.drawLine(0, 3, 399, 3);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11246().paint(g);
    }
}
