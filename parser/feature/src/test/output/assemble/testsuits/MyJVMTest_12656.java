public class MyJVMTest_12656 {

    static short[] a = { 0, 30207, 32767, 0, 0, 0, 32767, 0, 0, -24899 };

    static long[] b = { 0, 0, 1625310243341005735L, 4930140083749575872L, 0, 2947272853677306571L, 0, 5233092674566345508L, 9223372036854775807L, 0 };

    static short c = 0;

    static long d = -6715908085618056842L;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_vi_unaln(short[] a, long[] b, short c, long d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12656().test_vi_unaln(a, b, c, d);
    }
}
