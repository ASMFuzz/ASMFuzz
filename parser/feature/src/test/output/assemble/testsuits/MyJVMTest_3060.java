public class MyJVMTest_3060 {

    static long[] a = { -9223372036854775808L, 3666798368192931845L, -9223372036854775808L, -9223372036854775808L, 2029148079472746212L, 9223372036854775807L, 9223372036854775807L, 471553546257362799L, 7887854646466127754L, 3238137076842880206L };

    static long b = 9223372036854775807L;

    long[] test_vi_neg(long[] a, long b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3060().test_vi_neg(a, b);
    }
}
