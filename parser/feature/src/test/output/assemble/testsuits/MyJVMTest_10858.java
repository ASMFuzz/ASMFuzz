public class MyJVMTest_10858 {

    static byte[] a = { 104, 39, -118, 49, -8, 45, 66, -120, -25, 105 };

    static int[] b = { 1, -1959889312, 9, 2, 4, -1730517504, -573900975, 2, 0, 8 };

    static byte c = 127;

    static int d = 58133215;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, int[] b, byte c, int d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10858().test_vi_aln(a, b, c, d);
    }
}
