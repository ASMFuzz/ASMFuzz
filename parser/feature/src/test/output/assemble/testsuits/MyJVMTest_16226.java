public class MyJVMTest_16226 {

    static long[] a = { -2930583750134241561L, 1212225488520485996L, 996343592750807230L, 9223372036854775807L, -9223372036854775808L, 2926056049856639268L, -9223372036854775808L, 2337093726910347495L, 0, 1963852997686241330L };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.NaN, Float.MIN_VALUE, 0.10306829f, Float.POSITIVE_INFINITY, 0.7237746f };

    static long c = 9223372036854775807L;

    static float d = Float.NEGATIVE_INFINITY;

    long[] test_vi(long[] a, float[] b, long c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16226().test_vi(a, b, c, d);
    }
}
