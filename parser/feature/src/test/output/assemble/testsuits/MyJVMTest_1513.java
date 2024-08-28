public class MyJVMTest_1513 {

    static short[] a = { 30038, -25711, -32768, -32768, 32767, -32768, -32768, 0, -32768, 32767 };

    static short[] b = { 0, -32768, 0, -32768, 0, 0, 32767, 6215, 10595, -14663 };

    static long[] c = { -8663005396207502789L, 0, -9223372036854775808L, 1874034584926507512L, 9223372036854775807L, -9223372036854775808L, -3269573441060356599L, -7837158076853652134L, 0, 9223372036854775807L };

    static long[] d = { -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -190928812189431059L, -6542605787436524037L, 9223372036854775807L, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1513().test_cp_unalndst(a, b, c, d);
    }
}
