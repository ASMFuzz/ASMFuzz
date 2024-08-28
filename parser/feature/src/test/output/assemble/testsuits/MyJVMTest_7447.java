import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_7447 {

    static Graphics g = new Graphics2D();

    static BufferedImage bimg = null;

    Graphics paint(Graphics g) {
        g.drawImage(bimg, 0, 0, null);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7447().paint(g);
    }
}
