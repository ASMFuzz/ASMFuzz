import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11392 {

    static Graphics g = new Graphics2D();

    Graphics paint(Graphics g) {
        g.drawString("drawArc(25,50,150,100,45,90);", 25, 25);
        g.drawArc(25, 50, 150, 100, 45, 90);
        g.drawString("drawOval(25,200,200,40);", 25, 175);
        g.drawOval(25, 200, 200, 40);
        g.dispose();
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11392().paint(g);
    }
}
