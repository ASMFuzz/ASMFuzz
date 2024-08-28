import java.awt.*;
import java.awt.MultipleGradientPaint.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_16575 {

    static int srcParam1 = 411;

    static int srcParam2 = 391;

    static int srcParam3 = 348;

    static int srcParam4Param1 = 537;

    static int srcParam4Param2 = 891;

    static byte[] srcParam4Param3 = { -12, -3, -62, 105, -97, 27, -49, 113, -97, 15 };

    static int srcParam4Param4 = 996;

    static boolean srcParam4Param5 = false;

    static IndexColorModel srcParam4 = new IndexColorModel(srcParam4Param1, srcParam4Param2, srcParam4Param3, srcParam4Param4, srcParam4Param5);

    static BufferedImage src = new BufferedImage(srcParam1, srcParam2, srcParam3, srcParam4);

    static Image dst = null;

    static BufferedImage srcImg = null;

    static Image dstImg = null;

    Graphics2D renderToVI(BufferedImage src, Image dst) {
        Graphics2D g = (Graphics2D) dst.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dst.getWidth(null), dst.getHeight(null));
        AffineTransform at = new AffineTransform();
        g.setPaint(new LinearGradientPaint(new Point2D.Float(0, 0), new Point2D.Float(20, 0), new float[] { 0.0f, 1.0f }, new Color[] { Color.green, Color.blue }, CycleMethod.NO_CYCLE, ColorSpaceType.LINEAR_RGB, at));
        g.fillRect(-10, -10, 30, 30);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16575().renderToVI(src, dst);
    }
}
