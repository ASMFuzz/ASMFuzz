import java.awt.*;
import java.awt.MultipleGradientPaint.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_13263 {

    static BufferedImage srcImg = null;

    static Image dstImg = null;

    BufferedImage createSrcImage() {
        BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 10, 10);
        g.setColor(Color.black);
        g.drawLine(0, 0, 10, 10);
        return bi;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13263().createSrcImage());
    }
}
