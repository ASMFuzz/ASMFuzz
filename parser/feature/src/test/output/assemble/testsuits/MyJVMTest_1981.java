public class MyJVMTest_1981 {

    static byte[] a = { -22, 20, 64, 41, -120, -32, 124, 88, -100, 119 };

    static long[] b = { 0, -4606631858410742652L, 9223372036854775807L, 9223372036854775807L, 0, 3639096734908400334L, 0, 0, 9223372036854775807L, -9223372036854775808L };

    static byte c = -7;

    static long d = 9223372036854775807L;

    byte[] test_vi(byte[] a, long[] b, byte c, long d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1981().test_vi(a, b, c, d);
    }
}
