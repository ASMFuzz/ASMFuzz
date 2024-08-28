import java.awt.*;
import java.awt.image.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_9770 {

    static int x = 0;

    static int y = 2;

    static int w = 0;

    static int h = 0;

    static ICC_Profile modelParam1Param1 = null;

    static ColorSpace modelParam1 = new ICC_ColorSpace(modelParam1Param1);

    static int[] modelParam2 = { 0, -1860750866, 4, 0, -532057800, 5, 0, -2007485345, 4, 5 };

    static boolean modelParam3 = false;

    static boolean modelParam4 = false;

    static int modelParam5 = 540;

    static int modelParam6 = 207;

    static ColorModel model = new ComponentColorModel(modelParam1, modelParam2, modelParam3, modelParam4, modelParam5, modelParam6);

    static int[] pixels = { 1, 4, 1, 0, 0, 0, 0, 4, -1463211083, 0 };

    static int offset = 0;

    static int scansize = 0;

    static int refW = 1287612766, refH = 0, refType = 0;

    static boolean refHasAlpha = true;

    static Color refColor = null;

    ColorModel setPixels(int x, int y, int w, int h, ColorModel model, int[] pixels, int offset, int scansize) {
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
        new MyJVMTest_9770().setPixels(x, y, w, h, model, pixels, offset, scansize);
    }
}
