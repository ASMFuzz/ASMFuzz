public class MyJVMTest_9845 {

    static byte[] a = { -42, -102, -48, -102, -94, -94, -76, -85, 97, -29 };

    static byte[] b = { 99, -59, 42, -11, -62, -46, -83, -54, -23, 91 };

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
        new MyJVMTest_9845().test_2ci_unaln(a, b);
    }
}
