public class MyJVMTest_8432 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, -3191999612626731574L, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 5469644556586513641L, 6666789174042005476L, 0 };

    static long[] b = { -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 1855234539024556144L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -5450211520530580756L };

    static int SCALE = 2;

    long[] test_cp_scl(long[] a, long[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8432().test_cp_scl(a, b);
    }
}
