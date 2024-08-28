public class MyJVMTest_13800 {

    static byte[] a = { -103, -28, -77, -22, 101, -94, -123, 104, -12, 8 };

    static byte[] b = { 114, 90, 60, 97, 29, -94, -121, 54, 76, 40 };

    static byte c = -46;

    static byte d = -128;

    static int ALIGN_OFF = 8;

    byte[] test_2vi_aln(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13800().test_2vi_aln(a, b, c, d);
    }
}
