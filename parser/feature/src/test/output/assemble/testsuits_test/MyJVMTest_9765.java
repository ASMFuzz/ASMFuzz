public class MyJVMTest_9765 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, -163225821018122821L, 0, 0, 9223372036854775807L };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 6068946075342132646L, 0, 9223372036854775807L, 5246949499494414994L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    long[] test_cp_alnsrc(long[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9765().test_cp_alnsrc(a, b);
    }
}
