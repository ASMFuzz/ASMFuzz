public class MyJVMTest_599 {

    static long[] a = { 0, 0, -5496914163892998588L, 0, 9223372036854775807L, 0, 7870806911444218674L, 5784082085243742245L, 0, 9223372036854775807L };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, -1006254825829832715L, 9223372036854775807L, 1974224562615630746L, -9223372036854775808L, -6111678067388397908L, -9223372036854775808L, -9223372036854775808L, -370443277144959050L };

    static int ALIGN_OFF = 8;

    long[] test_cp_alnsrc(long[] a, long[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_599().test_cp_alnsrc(a, b);
    }
}
