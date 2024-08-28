import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_17366 {

    static BufferedImage bi = null;

    static boolean printed = false;

    void drawGui() {
        bi = new BufferedImage(200, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bi.createGraphics();
        BasicStroke dashStroke = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[] { 0.0f, 200 }, 1.0f);
        g2d.setStroke(dashStroke);
        g2d.setColor(Color.RED);
        g2d.drawLine(5, 10, 100, 10);
        printed = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17366().drawGui();
    }
}
