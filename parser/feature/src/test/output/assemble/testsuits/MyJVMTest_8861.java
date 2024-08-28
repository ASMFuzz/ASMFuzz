public class MyJVMTest_8861 {

    static long[] a = { 354042974766045765L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 0, 0 };

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
        new MyJVMTest_8861().check(a);
    }
}
