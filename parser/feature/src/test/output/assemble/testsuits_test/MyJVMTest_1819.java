import java.awt.Color;

public class MyJVMTest_1819 {

    static int c1Param1 = 445;

    static int c1Param2 = 488;

    static int c1Param3 = 441;

    static Color c1 = new Color(c1Param1, c1Param2, c1Param3);

    static float c2Param1 = Float.NEGATIVE_INFINITY;

    static float c2Param2 = 0f;

    static float c2Param3 = 0f;

    static float c2Param4 = 0f;

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
        System.out.println(new MyJVMTest_1819().sameColor(c1, c2));
    }
}
