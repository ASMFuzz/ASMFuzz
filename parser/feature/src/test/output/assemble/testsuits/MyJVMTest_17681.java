import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_17681 {

    static int rendImgParam1 = 293;

    static int rendImgParam2 = 480;

    static int rendImgParam3 = 687;

    static int rendImgParam4Param1 = 190;

    static int rendImgParam4Param2 = 552;

    static byte[] rendImgParam4Param3 = { 83, -39, 43, -88, -124, 92, 48, 14, -91, 112 };

    static int rendImgParam4Param4 = 705;

    static boolean rendImgParam4Param5 = false;

    static int rendImgParam4Param6 = 220;

    static IndexColorModel rendImgParam4 = new IndexColorModel(rendImgParam4Param1, rendImgParam4Param2, rendImgParam4Param3, rendImgParam4Param4, rendImgParam4Param5, rendImgParam4Param6);

    static BufferedImage rendImg = new BufferedImage(rendImgParam1, rendImgParam2, rendImgParam3, rendImgParam4);

    static int drawImgParam1 = 296;

    static int drawImgParam2 = 527;

    static int drawImgParam3 = 317;

    static int drawImgParam4Param1 = 299;

    static int drawImgParam4Param2 = 530;

    static int[] drawImgParam4Param3 = { 8, 634678645, 8, 1592365999, 4, 0, 0, 8, 0, 119617953 };

    static int drawImgParam4Param4 = 855;

    static boolean drawImgParam4Param5 = true;

    static int drawImgParam4Param6 = 881;

    static int drawImgParam4Param7 = 587;

    static IndexColorModel drawImgParam4 = new IndexColorModel(drawImgParam4Param1, drawImgParam4Param2, drawImgParam4Param3, drawImgParam4Param4, drawImgParam4Param5, drawImgParam4Param6, drawImgParam4Param7);

    static BufferedImage drawImg = new BufferedImage(drawImgParam1, drawImgParam2, drawImgParam3, drawImgParam4);

    static double s = 0.1196812683205547;

    Graphics2D test(BufferedImage rendImg, BufferedImage drawImg, double s) {
        Graphics2D g = drawImg.createGraphics();
        g.transform(new AffineTransform(s, 0.0, -1.0, 1.0, 0.0, 0.0));
        g.drawImage(rendImg, -rendImg.getWidth() / 2, -rendImg.getHeight() / 2, null);
        g.drawImage(rendImg, 0, 0, null);
        g.dispose();
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17681().test(rendImg, drawImg, s);
    }
}
