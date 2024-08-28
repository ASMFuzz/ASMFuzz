public class MyJVMTest_7990 {

    static float[] bx = {Float.MIN_VALUE,Float.MAX_VALUE,0f,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,0.7986431f,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.NaN,0.7104033f};

    static float[] by = {0f,0.7614425f,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,0.19171739f,Float.MAX_VALUE,0f,0f};

    static float[] vx = {Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY,Float.NaN,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,0f,Float.MAX_VALUE,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE};

    static float[] vy = {Float.NEGATIVE_INFINITY,0.80508345f,Float.NaN,Float.MIN_VALUE,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,0.7707162f,Float.NaN,Float.NaN,0.08147013f};

    static float r = Float.MIN_VALUE;

    static int n = 0;

    static float x0 = 0f;

    static float y0 = 0.62329745f;

    static float width = 0.7327278f;

    static float height = Float.NEGATIVE_INFINITY;

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
        new MyJVMTest_7990().update();
    }
}
