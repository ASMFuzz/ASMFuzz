public class MyJVMTest_3824 {

    static byte[] a = { -12, -64, -107, 124, -46, 1, 66, -111, -78, -103 };

    static long[] b = { -5260703215269462179L, 0, -9223372036854775808L, 0, 0, 989725019104904861L, 9223372036854775807L, -8164544215004793594L, 3152062286275889914L, 6527797936461990385L };

    byte[] test_ci(byte[] a, long[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3824().test_ci(a, b);
    }
}
