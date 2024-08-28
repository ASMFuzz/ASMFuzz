public class MyJVMTest_16237 {

    static long[] a = { -9223372036854775808L, 0, -6578429887019247513L, 0, 4209327224962784957L, -1113291945074507624L, -9223372036854775808L, -9223372036854775808L, -1804810050535137563L, -763533584405512415L };

    static long[] b = { 9223372036854775807L, -14628289366079147L, -8229205043549660743L, 0, 0, 9223372036854775807L, 0, 9041170595785917970L, 1461589955732758492L, 0 };

    static long c = -9223372036854775808L;

    static long d = -7459809889256127812L;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_2vi_unaln(long[] a, long[] b, long c, long d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16237().test_2vi_unaln(a, b, c, d);
    }
}
