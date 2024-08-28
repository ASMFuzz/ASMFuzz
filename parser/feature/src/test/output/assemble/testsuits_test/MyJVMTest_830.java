import java.awt.*;
import java.awt.color.*;
import java.awt.image.*;

public class MyJVMTest_830 {

    static int srcIndex = 4;

    static int destIndex = -149339206;

    static int[] colorSpaceType = { ColorSpace.CS_CIEXYZ, ColorSpace.CS_GRAY, ColorSpace.CS_LINEAR_RGB, ColorSpace.CS_PYCC, ColorSpace.CS_sRGB };

    static BufferedImage original = null;

    static ColorConvertOp colorOp = null;

    ColorConvertOp getColorConvertOp(int srcIndex, int destIndex) {
        ColorSpace srcColorSpace = ColorSpace.getInstance(colorSpaceType[srcIndex]);
        ColorSpace destColorSpace = ColorSpace.getInstance(colorSpaceType[destIndex]);
        return new ColorConvertOp(srcColorSpace, destColorSpace, null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_830().getColorConvertOp(srcIndex, destIndex));
    }
}
