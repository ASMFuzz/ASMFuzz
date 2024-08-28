public class MyJVMTest_9068 {

    static Object[] expected = { 1, 7, 248105873, 0, 7, 1898927799, 0, 0, 4, 7 };

    static Object[] actual = { 0, 9, 2, 0, 0, 3, 9, -1354068150, 1, 0 };

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
        new MyJVMTest_9068().validate(expected, actual);
    }
}
