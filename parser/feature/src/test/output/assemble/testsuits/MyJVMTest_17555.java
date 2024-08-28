public class MyJVMTest_17555 {

    static float[] bx = {Float.NEGATIVE_INFINITY,0f,Float.NaN,0.15341914f,Float.MIN_VALUE,Float.MIN_VALUE,0.18501514f,Float.MIN_VALUE,Float.NaN,0f};

    static float[] by = {Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.MAX_VALUE,Float.MAX_VALUE,0.9155594f,0f};

    static float[] vx = {Float.MIN_VALUE,Float.MAX_VALUE,Float.MIN_VALUE,Float.POSITIVE_INFINITY,0.4601593f,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.MIN_VALUE,0f};

    static float[] vy = {Float.MAX_VALUE,Float.NaN,Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NaN,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.NaN,Float.MAX_VALUE};

    static float r = Float.MAX_VALUE;

    static int n = 465462149;

    static float x0 = Float.NaN;

    static float y0 = Float.MIN_VALUE;

    static float width = Float.MAX_VALUE;

    static float height = 0.7828834f;

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
        new MyJVMTest_17555().update();
    }
}
