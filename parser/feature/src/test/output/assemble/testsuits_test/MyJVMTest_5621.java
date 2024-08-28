public class MyJVMTest_5621 {

    static byte[] a = { 97, -7, 19, -17, -45, -109, 90, -62, 121, -19 };

    static long[] b = { 9223372036854775807L, -317718162437192515L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, 183241110553745667L };

    static byte c = -128;

    static long d = 4768509139491860206L;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, long[] b, byte c, long d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5621().test_vi_unaln(a, b, c, d);
    }
}
