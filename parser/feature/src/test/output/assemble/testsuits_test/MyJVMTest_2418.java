public class MyJVMTest_2418 {

    static Object[] expected = { 0, 8, 0, 8, -1536081232, 7, 0, -1213969105, 0, -316092744 };

    static Object[] actual = { -455997707, 0, 6, 8, 579117377, -351698855, 0, 0, 7, 1 };

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
        new MyJVMTest_2418().validate(expected, actual);
    }
}
