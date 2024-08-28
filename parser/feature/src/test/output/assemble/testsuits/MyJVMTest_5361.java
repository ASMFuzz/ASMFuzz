import java.awt.*;
import java.awt.image.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_5361 {

    static ICC_Profile modelParam1Param1 = null;

    static ColorSpace modelParam1 = new ICC_ColorSpace(modelParam1Param1);

    static int[] modelParam2 = { 0, 0, 0, 1609647663, 0, 4, 7, 0, 0, 0 };

    static boolean modelParam3 = true;

    static boolean modelParam4 = true;

    static int modelParam5 = 959;

    static int modelParam6 = 689;

    static ColorModel model = new ComponentColorModel(modelParam1, modelParam2, modelParam3, modelParam4, modelParam5, modelParam6);

    static int refW = -1169074383, refH = 0, refType = 1;

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
        new MyJVMTest_5361().setColorModel(model);
    }
}
