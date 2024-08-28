import java.awt.Color;

public class MyJVMTest_11062 {

    static int aParam1 = 192;

    static int aParam2 = 889;

    static int aParam3 = 15;

    static Color a = new Color(aParam1, aParam2, aParam3);

    static float bParam1 = Float.MAX_VALUE;

    static float bParam2 = Float.MAX_VALUE;

    static float bParam3 = Float.POSITIVE_INFINITY;

    static Color b = new Color(bParam1, bParam2, bParam3);

    static float delta = Float.NEGATIVE_INFINITY;

    static int h = 100;

    boolean compareWithTolerance(Color a, Color b, float delta) {
        float[] a_rgb = new float[3];
        a_rgb = a.getRGBColorComponents(a_rgb);
        float[] b_rgb = new float[3];
        b_rgb = b.getRGBColorComponents(b_rgb);
        for (int i = 0; i < 3; i++) {
            if (Math.abs(a_rgb[i] - b_rgb[i]) > delta) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11062().compareWithTolerance(a, b, delta));
    }
}
