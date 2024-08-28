import java.awt.*;
import java.awt.image.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_14786 {

    static ICC_Profile modelParam1Param1 = null;

    static ColorSpace modelParam1 = new ICC_ColorSpace(modelParam1Param1);

    static int[] modelParam2 = { 3, -1102408952, 0, 0, 4, 8, -1164573361, 2, 0, 2 };

    static boolean modelParam3 = false;

    static boolean modelParam4 = false;

    static int modelParam5 = 476;

    static int modelParam6 = 494;

    static ColorModel model = new ComponentColorModel(modelParam1, modelParam2, modelParam3, modelParam4, modelParam5, modelParam6);

    static int refW = -118985881, refH = 1, refType = 7;

    static boolean refHasAlpha = true;

    static Color refColor = null;

    ColorModel setColorModel(ColorModel model) {
        boolean a = model.hasAlpha();
        if (a != refHasAlpha) {
            throw new RuntimeException("invalid hasAlpha: " + a);
        }
        int tt = model.getTransferType();
        if (tt != refType) {
            throw new RuntimeException("invalid transfer type: " + tt);
        }
        return model;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14786().setColorModel(model);
    }
}
