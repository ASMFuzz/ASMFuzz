public class MyJVMTest_11798 {

    static int[] a = { 0, 9, -255182285, 0, 6, 96522246, 0, 1851219913, 0, 0 };

    static int[] b = { 0, 1182973871, -256860021, 0, 8, 0, 0, 0, 0, 7 };

    static long[] c = { -9223372036854775808L, -8536724590508830127L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, -4191327516365606364L, -9223372036854775808L, 0 };

    static long[] d = { -2659076501304297534L, 0, 0, 9223372036854775807L, 9223372036854775807L, -1644645960744011946L, 0, 9223372036854775807L, -9223372036854775808L, 0 };

    static int ALIGN_OFF = 8;

    int[] test_cp_alndst(int[] a, int[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11798().test_cp_alndst(a, b, c, d);
    }
}
