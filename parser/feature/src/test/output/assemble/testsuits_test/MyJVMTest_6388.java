public class MyJVMTest_6388 {

    static short[] a = { 32767, -32768, 0, 32767, 32767, -32768, 32767, 0, 32767, 608 };

    static short[] b = { 32767, -32768, 32767, 32767, -32768, -32768, 32767, -27224, 0, -32768 };

    static long[] c = { 0, -8456724947992176831L, 9223372036854775807L, -3455541755162024789L, 0, 9223372036854775807L, 9223372036854775807L, 0, 0, -9223372036854775808L };

    static long[] d = { 0, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, 0, 5061605389918039216L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6388().test_cp_alndst(a, b, c, d);
    }
}
