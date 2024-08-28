public class MyJVMTest_13552 {

    static byte[] a = { 71, -94, -49, 54, 86, -108, 44, -93, -19, 54 };

    static int[] b = { -1625558922, 0, -118536970, 1, 1288013289, 6, 9, 0, 4, 6 };

    static int ALIGN_OFF = 8;

    byte[] test_ci_aln(byte[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13552().test_ci_aln(a, b);
    }
}
