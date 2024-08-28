import java.awt.*;
import java.awt.image.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_10229 {

    static int x = 0;

    static int y = 6;

    static int w = -1727274578;

    static int h = 1;

    static ICC_Profile modelParam1Param1 = null;

    static ColorSpace modelParam1 = new ICC_ColorSpace(modelParam1Param1);

    static boolean modelParam2 = false;

    static boolean modelParam3 = true;

    static int modelParam4 = 28;

    static int modelParam5 = 684;

    static ColorModel model = new ComponentColorModel(modelParam1, modelParam2, modelParam3, modelParam4, modelParam5);

    static byte[] pixels = { 36, -96, 46, 66, -10, -128, 107, -122, 125, -34 };

    static int offset = 1868075984;

    static int scansize = -74871376;

    static int refW = -153779506, refH = 1809153634, refType = 5;

    static boolean refHasAlpha = true;

    static Color refColor = null;

    ColorModel setPixels(int x, int y, int w, int h, ColorModel model, byte[] pixels, int offset, int scansize) {
        for (int i = 0; i < pixels.length; i++) {
            int p = pixels[i];
            Color c = model.hasAlpha() ? new Color(model.getRed(p), model.getGreen(p), model.getBlue(p), model.getAlpha(p)) : new Color(model.getRGB(p));
            if (!c.equals(refColor)) {
                throw new RuntimeException("invalid color: " + c + ", expected: " + refColor);
            }
        }
        return model;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10229().setPixels(x, y, w, h, model, pixels, offset, scansize);
    }
}
