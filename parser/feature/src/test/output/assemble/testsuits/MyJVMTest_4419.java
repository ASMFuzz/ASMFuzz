public class MyJVMTest_4419 {

    static byte[] a = { 103, -116, 55, -70, -14, 25, -4, 101, -103, -63 };

    static byte[] b = { -114, -23, 116, -101, 97, 111, -45, -125, 45, -87 };

    static byte c = 127;

    static byte d = -26;

    static int ALIGN_OFF = 8;

    byte[] test_2vi_aln(byte[] a, byte[] b, byte c, byte d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4419().test_2vi_aln(a, b, c, d);
    }
}
