public class MyJVMTest_2954 {

    static byte[] a = { 0, -3, -50, 86, 43, -90, 123, -121, -102, 55 };

    static short[] b = { 32767, 32767, 0, 32767, 0, -14374, 0, 0, -32768, 32767 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_ci_unaln(byte[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2954().test_ci_unaln(a, b);
    }
}
