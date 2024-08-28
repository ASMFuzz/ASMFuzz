import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Graphics2D;

public class MyJVMTest_160 {

    static Component c = new Container();

    static Graphics g = new Graphics2D();

    static int x = 2;

    static int y = 0;

    Graphics paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(java.awt.Color.black);
        g.fillRect(x, y, 16, 16);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_160().paintIcon(c, g, x, y);
    }
}
