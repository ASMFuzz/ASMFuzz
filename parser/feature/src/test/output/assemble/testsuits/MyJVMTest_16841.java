public class MyJVMTest_16841 {

    static float x = Float.NaN;

    static float y = 0.6281062f;

    static float w = Float.NaN;

    static float h = Float.MAX_VALUE;

    static Object rectTex = 1;

    static Object wrapTex = 8;

    static float bx = Float.MIN_VALUE;

    static float by = Float.POSITIVE_INFINITY;

    static float bw = Float.NEGATIVE_INFINITY;

    static float bh = Float.MIN_VALUE;

    static float f1 = Float.NEGATIVE_INFINITY;

    static float f2 = 0.9937235f;

    static float f3 = Float.POSITIVE_INFINITY;

    static float f4 = 0f;

    static float f5 = Float.POSITIVE_INFINITY;

    static float f6 = Float.POSITIVE_INFINITY;

    static float f7 = Float.MIN_VALUE;

    static float f8 = 0.3868354f;

    static int i1 = 0;

    static int i2 = 511704049;

    boolean fillPrimRect(float x, float y, float w, float h, Object rectTex, Object wrapTex, float bx, float by, float bw, float bh, float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i1, int i2) {
        System.out.println(x + " " + y + " " + w + " " + h + " " + bx + " " + by + " " + bw + " " + bh);
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16841().fillPrimRect(x, y, w, h, rectTex, wrapTex, bx, by, bw, bh, f1, f2, f3, f4, f5, f6, f7, f8, i1, i2));
    }
}
