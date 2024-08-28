import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.color.*;

public class MyJVMTest_1930 {

    static int IMG_WIDTH = 100;

    static int IMG_HEIGHT = 100;

    BufferedImage createCustomImage() {
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        ComponentColorModel cm = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_FLOAT);
        WritableRaster raster = cm.createCompatibleWritableRaster(IMG_WIDTH, IMG_HEIGHT);
        return new BufferedImage(cm, raster, false, null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1930().createCustomImage());
    }
}
