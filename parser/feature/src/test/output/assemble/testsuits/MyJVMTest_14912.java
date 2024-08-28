public class MyJVMTest_14912 {

    static short[] a = { -24325, -32768, 3796, 9510, 32767, 0, 32767, -28386, -32768, -32768 };

    static long[] b = { 3985704848582165906L, 0, 4955803242097778395L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_ci_unaln(short[] a, long[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14912().test_ci_unaln(a, b);
    }
}
