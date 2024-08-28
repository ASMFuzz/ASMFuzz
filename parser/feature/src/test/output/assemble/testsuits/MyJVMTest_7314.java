public class MyJVMTest_7314 {

    static float x = Float.NaN;

    static float y = Float.MAX_VALUE;

    static float w = 0f;

    static float h = Float.POSITIVE_INFINITY;

    static Object rectTex = 675413577;

    static Object wrapTex = 0;

    static float bx = Float.MAX_VALUE;

    static float by = 0f;

    static float bw = Float.POSITIVE_INFINITY;

    static float bh = 0.33114713f;

    static float f1 = Float.MIN_VALUE;

    static float f2 = Float.POSITIVE_INFINITY;

    static float f3 = Float.NaN;

    static float f4 = Float.NEGATIVE_INFINITY;

    static float f5 = 0.21243209f;

    static float f6 = Float.NaN;

    static float f7 = 0.5634339f;

    static float f8 = Float.NEGATIVE_INFINITY;

    static int i1 = 107656248;

    static int i2 = 6;

    boolean fillPrimRect(float x, float y, float w, float h, Object rectTex, Object wrapTex, float bx, float by, float bw, float bh, float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i1, int i2) {
        System.out.println(x + " " + y + " " + w + " " + h + " " + bx + " " + by + " " + bw + " " + bh);
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7314().fillPrimRect(x, y, w, h, rectTex, wrapTex, bx, by, bw, bh, f1, f2, f3, f4, f5, f6, f7, f8, i1, i2));
    }
}
