public class MyJVMTest_6959 {

    static byte[] a = { 38, -61, 80, -17, 113, 91, -84, -96, 75, -6 };

    static int[] b = { 6, 0, -356607449, 9, 0, 5, 0, 9, 0, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, int[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6959().test_ci_unaln(a, b);
    }
}
