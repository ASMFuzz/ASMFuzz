public class MyJVMTest_17140 {

    static long[] a = { -8835923317226317102L, -459239554314029557L, 0, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 860266406963473222L, -6693858449017219728L, 0 };

    static long[] b = { -9223372036854775808L, 854272154891260143L, -9223372036854775808L, 0, 0, 0, -6266425397133942226L, -9223372036854775808L, 0, 0 };

    static int SCALE = 2;

    long[] test_2ci_scl(long[] a, long[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17140().test_2ci_scl(a, b);
    }
}
