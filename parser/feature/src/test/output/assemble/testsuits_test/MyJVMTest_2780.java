public class MyJVMTest_2780 {

    static short[] a = { 0, 32767, 32767, 7183, 11909, 0, 32767, 32767, 0, 8421 };

    static short[] b = { -32768, 32767, -32768, 32767, 32767, -12334, -5963, 0, 32767, 32767 };

    static long[] c = { 0, 0, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, -2398609280636106464L };

    static long[] d = { 2666386225059220213L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -1069636532017252967L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -3437084453711758453L };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2780().test_cp_alnsrc(a, b, c, d);
    }
}
