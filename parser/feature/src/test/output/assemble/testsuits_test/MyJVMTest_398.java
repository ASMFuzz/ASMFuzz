public class MyJVMTest_398 {

    static long[] a = { 9223372036854775807L, 0, 0, -9223372036854775808L, -9160006977783737251L, -9223372036854775808L, 0, 7341632397054740523L, 5418468244634018954L, 5823196998502183458L };

    static long[] b = { 0, -4623942283051493050L, 1599403776894670476L, -9223372036854775808L, 9223372036854775807L, -7378213016976537812L, 9223372036854775807L, 5703181946259510882L, -9223372036854775808L, 0 };

    static long c = -2602168206262830905L;

    static long d = -5338881527697986669L;

    long[] test_2vi_neg(long[] a, long[] b, long c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_398().test_2vi_neg(a, b, c, d);
    }
}
