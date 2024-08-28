import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class MyJVMTest_14227 {

    static int srcParam1 = 494;

    static int srcParam2 = 751;

    static int srcParam3 = 118;

    static int srcParam4Param1 = 419;

    static int srcParam4Param2 = 322;

    static int[] srcParam4Param3 = { 4, 3, 0, 885512305, 5, 2, 1678318495, 2, 0, 3 };

    static int srcParam4Param4 = 5;

    static boolean srcParam4Param5 = false;

    static int srcParam4Param6 = 133;

    static int srcParam4Param7 = 940;

    static IndexColorModel srcParam4 = new IndexColorModel(srcParam4Param1, srcParam4Param2, srcParam4Param3, srcParam4Param4, srcParam4Param5, srcParam4Param6, srcParam4Param7);

    static BufferedImage src = new BufferedImage(srcParam1, srcParam2, srcParam3, srcParam4);

    static Image dst = null;

    Graphics2D renderToVI(BufferedImage src, Image dst) {
        Graphics2D g = (Graphics2D) dst.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 50, 50);
        g.rotate(0.5f);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setComposite(AlphaComposite.SrcOver.derive(1f));
        g.drawImage(src, 10, 10, null);
        g.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        g.drawImage(src, 20, 20, null);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14227().renderToVI(src, dst);
    }
}
