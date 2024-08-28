public class MyJVMTest_12371 {

    static long[] a = { 0, 0, 0, 0, 0, -332509403646308791L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0 };

    static long b = 0;

    long[] test_vi_neg(long[] a, long b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12371().test_vi_neg(a, b);
    }
}
