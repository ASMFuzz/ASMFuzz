import java.awt.Color;

public class MyJVMTest_1836 {

    static int aParam1 = 180;

    static int aParam2 = 403;

    static int aParam3 = 50;

    static Color a = new Color(aParam1, aParam2, aParam3);

    static int bParam1 = 13;

    static int bParam2 = 872;

    static int bParam3 = 172;

    static Color b = new Color(bParam1, bParam2, bParam3);

    static float delta = Float.NaN;

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
        System.out.println(new MyJVMTest_1836().compareWithTolerance(a, b, delta));
    }
}
