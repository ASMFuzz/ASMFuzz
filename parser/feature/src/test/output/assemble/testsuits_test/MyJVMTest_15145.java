import java.awt.*;
import javax.swing.*;

public class MyJVMTest_15145 {

    static Graphics2D g = null;

    static AlphaComposite ac = null;

    static int w = 1229823857;

    static int h = 4;

    static Robot robot = null;

    Graphics2D renderComposite(Graphics2D g, AlphaComposite ac, int w, int h) {
        g.setComposite(AlphaComposite.SrcOver);
        g.setPaint(Color.red);
        g.fillRect(0, 0, w, h);
        g.setComposite(ac);
        g.setPaint(Color.blue);
        g.fillRect(w / 4, h / 4, w / 2, h / 2);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15145().renderComposite(g, ac, w, h);
    }
}
