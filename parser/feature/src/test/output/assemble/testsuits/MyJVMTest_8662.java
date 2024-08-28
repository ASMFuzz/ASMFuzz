public class MyJVMTest_8662 {

    static float a = 0.3810045f;

    static float b = 0.6768278f;

    static float fmin = Float.NaN;

    static float fmax = 0f;

    static float fadd = Float.POSITIVE_INFINITY;

    static float fmul = Float.POSITIVE_INFINITY;

    static float efmin = Float.NaN;

    static float efmax = 0f;

    static float efadd = Float.POSITIVE_INFINITY;

    static float efmul = 0f;

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
        new MyJVMTest_8662().fCheck(a, b, fmin, fmax, fadd, fmul, efmin, efmax, efadd, efmul);
    }
}
