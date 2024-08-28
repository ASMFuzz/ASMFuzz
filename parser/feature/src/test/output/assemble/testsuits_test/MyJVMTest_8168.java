public class MyJVMTest_8168 {

    static long[] a = { 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -1756685215458581661L, -9223372036854775808L, 9223372036854775807L, 0, 9014795266936974393L, 9223372036854775807L, 0 };

    long[] test_ci_neg(long[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8168().test_ci_neg(a);
    }
}
