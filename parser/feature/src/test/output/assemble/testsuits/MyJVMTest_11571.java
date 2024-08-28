public class MyJVMTest_11571 {

    static short[] a = { 0, -438, 24194, 1328, -32768, 18621, 32767, -32768, -32768, -32768 };

    static long[] b = { 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 5932138014024539429L, -9223372036854775808L, 0, -9223372036854775808L, -9223372036854775808L };

    static short c = -32768;

    static long d = -9223372036854775808L;

    short[] test_vi_oppos(short[] a, long[] b, short c, long d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11571().test_vi_oppos(a, b, c, d);
    }
}
