public class MyJVMTest_2659 {

    static short[] a = { 0, 32767, -32768, -32768, 0, 0, 0, 32767, -32768, 32767 };

    static short[] b = { -32768, 32767, -13873, -32768, 32767, 0, -32768, -32509, 1919, 15147 };

    static long[] c = { 0, 0, 9223372036854775807L, 0, 0, 0, 0, 0, 0, -9223372036854775808L };

    static long[] d = { 0, 9223372036854775807L, 5242083826702916830L, 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 4560709590547883816L };

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
        new MyJVMTest_2659().test_cp_unalnsrc(a, b, c, d);
    }
}
