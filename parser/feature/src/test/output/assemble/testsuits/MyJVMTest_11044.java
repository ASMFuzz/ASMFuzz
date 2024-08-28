import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;

public class MyJVMTest_11044 {

    static ICC_Profile c1Param1Param1 = null;

    static ColorSpace c1Param1 = new ICC_ColorSpace(c1Param1Param1);

    static float[] c1Param2 = { Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, 0.16590601f, Float.NaN, Float.MIN_VALUE, 0.86484796f, Float.MIN_VALUE, Float.NaN, 0f };

    static float c1Param3 = Float.MAX_VALUE;

    static Color c1 = new Color(c1Param1, c1Param2, c1Param3);

    static float c2Param1 = Float.NaN;

    static float c2Param2 = 0f;

    static float c2Param3 = Float.MAX_VALUE;

    static float c2Param4 = Float.POSITIVE_INFINITY;

    static Color c2 = new Color(c2Param1, c2Param2, c2Param3, c2Param4);

    boolean sameColor(Color c1, Color c2) {
        final float delta = 0.1f;
        float[] rgb1 = new float[4];
        float[] rgb2 = new float[4];
        rgb1 = c1.getRGBComponents(rgb1);
        rgb2 = c2.getRGBComponents(rgb2);
        for (int i = 0; i < rgb1.length; i++) {
            if (Math.abs(rgb1[i] - rgb2[i]) > delta) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11044().sameColor(c1, c2));
    }
}
