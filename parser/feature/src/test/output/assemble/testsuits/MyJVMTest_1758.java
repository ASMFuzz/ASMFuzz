public class MyJVMTest_1758 {

    static float a = 0f;

    static float b = Float.NaN;

    static float fmin = Float.NaN;

    static float fmax = 0.58552957f;

    static float fadd = Float.NEGATIVE_INFINITY;

    static float fmul = Float.POSITIVE_INFINITY;

    static float efmin = Float.NEGATIVE_INFINITY;

    static float efmax = Float.NEGATIVE_INFINITY;

    static float efadd = Float.NEGATIVE_INFINITY;

    static float efmul = Float.MIN_VALUE;

    float fCheck(float a, float b, float fmin, float fmax, float fadd, float fmul, float efmin, float efmax, float efadd, float efmul) {
        int min = Float.floatToRawIntBits(fmin);
        int max = Float.floatToRawIntBits(fmax);
        int add = Float.floatToRawIntBits(fadd);
        int mul = Float.floatToRawIntBits(fmul);
        int emin = Float.floatToRawIntBits(efmin);
        int emax = Float.floatToRawIntBits(efmax);
        int eadd = Float.floatToRawIntBits(efadd);
        int emul = Float.floatToRawIntBits(efmul);
        if (min != emin || max != emax || add != eadd || mul != emul) {
            throw new AssertionError("Unexpected result of float test: " + "a = " + a + ", b = " + b + ", " + "result = (" + fmin + ", " + fmax + ", " + fadd + ", " + fmul + "), " + "expected = (" + efmin + ", " + efmax + ", " + efadd + ", " + efmul + ")");
        }
        return efadd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1758().fCheck(a, b, fmin, fmax, fadd, fmul, efmin, efmax, efadd, efmul);
    }
}
