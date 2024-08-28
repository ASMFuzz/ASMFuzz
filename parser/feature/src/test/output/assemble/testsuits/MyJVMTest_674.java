public class MyJVMTest_674 {

    static byte[] a = { -54, 81, 45, 32, 91, 123, -10, 114, -65, -59 };

    static byte[] b = { -65, -24, -26, -109, -72, -115, -127, 120, 9, 98 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_2ci_unaln(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_674().test_2ci_unaln(a, b);
    }
}
