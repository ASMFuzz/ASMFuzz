import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_14077 {

    static int size = 0;

    static int type = 0;

    static RescaleOp rescale1band = null, rescale3band = null, rescale4band = null;

    BufferedImage makeSourceImage(int size, int type) {
        int s2 = size / 2;
        BufferedImage img = new BufferedImage(size, size, type);
        Graphics2D g2d = img.createGraphics();
        g2d.setComposite(AlphaComposite.Src);
        g2d.setColor(Color.orange);
        g2d.fillRect(0, 0, size, size);
        g2d.setColor(Color.red);
        g2d.fillRect(0, 0, s2, s2);
        g2d.setColor(Color.green);
        g2d.fillRect(s2, 0, s2, s2);
        g2d.setColor(Color.blue);
        g2d.fillRect(0, s2, s2, s2);
        g2d.setColor(new Color(255, 255, 0, 128));
        g2d.fillRect(s2, s2, s2, s2);
        g2d.setColor(Color.pink);
        g2d.fillOval(s2 - 3, s2 - 3, 6, 6);
        g2d.dispose();
        return img;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14077().makeSourceImage(size, type));
    }
}
