public class MyJVMTest_8693 {

    static float[] bx = {Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.NaN,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.NaN,0f,0f,Float.NEGATIVE_INFINITY,Float.MIN_VALUE};

    static float[] by = {0.988929f,0.55760694f,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,0.3504988f,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.NaN,Float.POSITIVE_INFINITY};

    static float[] vx = {Float.NEGATIVE_INFINITY,Float.MAX_VALUE,Float.NaN,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.MIN_VALUE,Float.MIN_VALUE,0f,Float.MIN_VALUE,0.23155808f};

    static float[] vy = {Float.POSITIVE_INFINITY,0.480846f,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,Float.NaN,Float.POSITIVE_INFINITY,Float.MAX_VALUE,Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY,Float.MAX_VALUE};

    static float r = Float.MAX_VALUE;

    static int n = 7;

    static float x0 = Float.NaN;

    static float y0 = Float.MAX_VALUE;

    static float width = Float.MAX_VALUE;

    static float height = Float.POSITIVE_INFINITY;

    void update() {
        for (int i = 0; i < n; i++) {
            bx[i] += vx[i];
            if (bx[i] + r > width || bx[i] - r < x0)
                vx[i] = -vx[i];
            by[i] += vy[i];
            if (by[i] + r > height || by[i] - r < y0)
                vy[i] = -vy[i];
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8693().update();
    }
}
