import java.awt.*;
import java.awt.MultipleGradientPaint.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_16486 {

    static int srcParam1 = 656;

    static int srcParam2 = 764;

    static int srcParam3 = 753;

    static int srcParam4Param1 = 863;

    static int srcParam4Param2 = 721;

    static int[] srcParam4Param3 = { 3, 0, 854000361, 4, 7, -1496311621, 1578209204, 0, 4, 1537477628 };

    static int srcParam4Param4 = 448;

    static boolean srcParam4Param5 = false;

    static int srcParam4Param6 = 744;

    static int srcParam4Param7 = 162;

    static IndexColorModel srcParam4 = new IndexColorModel(srcParam4Param1, srcParam4Param2, srcParam4Param3, srcParam4Param4, srcParam4Param5, srcParam4Param6, srcParam4Param7);

    static BufferedImage src = new BufferedImage(srcParam1, srcParam2, srcParam3, srcParam4);

    static Image dst = null;

    static BufferedImage srcImg = null;

    static Image dstImg = null;

    Graphics2D renderToVI(BufferedImage src, Image dst) {
        Graphics2D g = (Graphics2D) dst.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dst.getWidth(null), dst.getHeight(null));
        AffineTransform at = new AffineTransform();
        at.translate(-100, 0);
        g.setPaint(new LinearGradientPaint(new Point2D.Float(100, 0), new Point2D.Float(120, 0), new float[] { 0.0f, 0.75f, 1.0f }, new Color[] { Color.red, Color.green, Color.blue }, CycleMethod.NO_CYCLE, ColorSpaceType.SRGB, at));
        g.fillRect(-10, -10, 30, 30);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16486().renderToVI(src, dst);
    }
}
