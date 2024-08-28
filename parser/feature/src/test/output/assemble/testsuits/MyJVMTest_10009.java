import java.awt.*;
import java.awt.color.*;
import java.awt.image.*;

public class MyJVMTest_10009 {

    static int srcIndex = 0;

    static int destIndex = 8;

    static int[] colorSpaceType = { ColorSpace.CS_CIEXYZ, ColorSpace.CS_GRAY, ColorSpace.CS_LINEAR_RGB, ColorSpace.CS_PYCC, ColorSpace.CS_sRGB };

    static BufferedImage original = null;

    static ColorConvertOp colorOp = null;

    ColorConvertOp getColorConvertOp(int srcIndex, int destIndex) {
        ColorSpace srcColorSpace = ColorSpace.getInstance(colorSpaceType[srcIndex]);
        ColorSpace destColorSpace = ColorSpace.getInstance(colorSpaceType[destIndex]);
        return new ColorConvertOp(srcColorSpace, destColorSpace, null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10009().getColorConvertOp(srcIndex, destIndex));
    }
}
