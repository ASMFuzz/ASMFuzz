public class MyJVMTest_12703 {

    static short[] a = { -32768, 0, -32768, 0, 32767, -32768, 32767, 32767, 32767, -16578 };

    static long[] b = { -4011498250573787953L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, -8908216102696764545L, 9223372036854775807L, 9223372036854775807L, 0, 0 };

    short[] test_ci_neg(short[] a, long[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12703().test_ci_neg(a, b);
    }
}
