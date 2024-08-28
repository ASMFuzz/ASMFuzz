public class MyJVMTest_16491 {

    static long[] a = { 0, -5778342794688312393L, 0, -9223372036854775808L, -9223372036854775808L, 0, -566915845962324819L, 0, -9223372036854775808L, -9223372036854775808L };

    static long b = 0;

    long[] check(long[] a) {
        for (int j = 0; j < 20; j++) {
            if (j >= 2 && j <= 6) {
                if (a[j] != 132) {
                    throw new RuntimeException("expected 132 at index " + j + " but got " + a[j]);
                }
            } else if (a[j] != 0) {
                throw new RuntimeException("expected 0 at index " + j + " but got " + a[j]);
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16491().check(a);
    }
}
