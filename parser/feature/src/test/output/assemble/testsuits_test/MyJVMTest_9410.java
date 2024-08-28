public class MyJVMTest_9410 {

    static byte[] a = { -73, 11, -97, 38, 120, 57, 84, 17, 7, -72 };

    static long[] b = { -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L };

    static byte c = 0;

    static long d = -1397590727238298074L;

    byte[] test_vi_oppos(byte[] a, long[] b, byte c, long d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9410().test_vi_oppos(a, b, c, d);
    }
}
