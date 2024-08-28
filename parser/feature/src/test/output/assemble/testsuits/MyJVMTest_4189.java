public class MyJVMTest_4189 {

    static byte[] a = { -91, 105, 10, -13, 39, -64, 51, 100, -61, 89 };

    static int[] b = { 5, -101938417, 0, -568855202, 0, 1730581196, 2, 8, 8, 8 };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4189().test_ci_aln(a, b);
    }
}
