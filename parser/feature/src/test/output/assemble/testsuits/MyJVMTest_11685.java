public class MyJVMTest_11685 {

    static Object[] expected = { 0, 7, 1747933979, 1520165742, 6, 0, -1359750036, 8, 1028312564, 0 };

    static Object[] actual = { 0, 0, 0, 3, 7, -1418153164, 811977945, 5, 9, 6 };

    static String[] KEYS = { "ColorChooser.okText", "ColorChooser.cancelText", "ColorChooser.resetText", "ColorChooser.resetMnemonic", "ColorChooser.swatchesNameText", "ColorChooser.swatchesMnemonic", "ColorChooser.swatchesSwatchSize", "ColorChooser.swatchesRecentText", "ColorChooser.swatchesRecentSwatchSize", "ColorChooser.hsvNameText", "ColorChooser.hsvMnemonic", "ColorChooser.hsvHueText", "ColorChooser.hsvSaturationText", "ColorChooser.hsvValueText", "ColorChooser.hsvTransparencyText", "ColorChooser.hslNameText", "ColorChooser.hslMnemonic", "ColorChooser.hslHueText", "ColorChooser.hslSaturationText", "ColorChooser.hslLightnessText", "ColorChooser.hslTransparencyText", "ColorChooser.rgbNameText", "ColorChooser.rgbMnemonic", "ColorChooser.rgbRedText", "ColorChooser.rgbGreenText", "ColorChooser.rgbBlueText", "ColorChooser.rgbAlphaText", "ColorChooser.rgbHexCodeText", "ColorChooser.rgbHexCodeMnemonic", "ColorChooser.cmykNameText", "ColorChooser.cmykMnemonic", "ColorChooser.cmykCyanText", "ColorChooser.cmykMagentaText", "ColorChooser.cmykYellowText", "ColorChooser.cmykBlackText", "ColorChooser.cmykAlphaText" };

    int validate(Object[] expected, Object[] actual) {
        int count = expected.length;
        if (count != actual.length) {
            throw new Error("different size: " + count + " <> " + actual.length);
        }
        for (int i = 0; i < count; i++) {
            if (!expected[i].equals(actual[i])) {
                throw new Error("unexpected value for key: " + KEYS[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11685().validate(expected, actual);
    }
}
