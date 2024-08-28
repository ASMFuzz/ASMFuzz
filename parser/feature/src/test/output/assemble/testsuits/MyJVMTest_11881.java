public class MyJVMTest_11881 {

    static byte[] a = { 37, -78, -18, 16, 18, -74, 40, 32, -28, 54 };

    static byte[] b = { 40, 32, 92, -57, -113, 3, 96, -32, 98, -72 };

    static int ALIGN_OFF = 8;

    byte[] test_2ci_aln(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11881().test_2ci_aln(a, b);
    }
}
