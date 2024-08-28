import java.awt.*;
import java.applet.Applet;

public class MyJVMTest_16807 {

    static Component comp = new Container();

    static Graphics g = new Graphics2D();

    static Color color = new Color();

    Dimension paintOutsideBounds(Component comp, Graphics g, Color color) {
        Dimension dim = comp.getSize();
        g.setColor(color);
        g.setClip(0, 0, dim.width * 2, dim.height * 2);
        for (int i = 0; i < dim.height * 2; i += 10) {
            g.drawLine(dim.width, i, dim.width * 2, i);
        }
        g.setClip(null);
        for (int i = 0; i < dim.width * 2; i += 10) {
            g.drawLine(i, dim.height, i, dim.height * 2);
        }
        g.setClip(new Rectangle(0, 0, dim.width * 2, dim.height * 2));
        for (int i = 0; i < dim.width; i += 10) {
            g.drawLine(dim.width * 2 - i, 0, dim.width * 2, i);
        }
        return dim;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16807().paintOutsideBounds(comp, g, color);
    }
}
