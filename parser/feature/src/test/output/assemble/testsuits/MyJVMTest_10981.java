public class MyJVMTest_10981 {

    static float a = Float.NaN;

    static float b = Float.POSITIVE_INFINITY;

    static float fmin = Float.NaN;

    static float fmax = Float.NaN;

    static float fadd = Float.MIN_VALUE;

    static float fmul = Float.MIN_VALUE;

    static float efmin = 0.6699388f;

    static float efmax = Float.NEGATIVE_INFINITY;

    static float efadd = 0.5051203f;

    static float efmul = Float.POSITIVE_INFINITY;

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
        new MyJVMTest_10981().fCheck(a, b, fmin, fmax, fadd, fmul, efmin, efmax, efadd, efmul);
    }
}
