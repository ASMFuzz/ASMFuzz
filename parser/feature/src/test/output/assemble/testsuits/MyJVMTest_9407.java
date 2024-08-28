public class MyJVMTest_9407 {

    static long[] a = { 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -2339554972452189137L, -9223372036854775808L, 4298335892968519530L };

    static long[] b = { 7252883470800060077L, 9223372036854775807L, -8587569394207491466L, -1082750080969938742L, 0, 0, 9223372036854775807L, 0, 0, 8567762025808017826L };

    static int ALIGN_OFF = 8;

    long[] test_cp_alndst(long[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9407().test_cp_alndst(a, b);
    }
}
