public class MyJVMTest_11942 {

    static short[] a = { 0, -32768, 32767, 10958, -32768, 32767, 32607, 32767, -8348, -32768 };

    static short[] b = { -32768, 18553, 0, 0, -32768, 32767, 32767, 32767, 0, -12123 };

    static long[] c = { 790397474497975217L, 447313132645449868L, -2602588443440081997L, 0, 0, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -5691447120482062659L };

    static long[] d = { 9223372036854775807L, -9223372036854775808L, 6530091435267561900L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, 0, -454832314173215886L, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11942().test_cp_unalnsrc(a, b, c, d);
    }
}
