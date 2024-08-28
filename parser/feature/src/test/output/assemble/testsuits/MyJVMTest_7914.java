public class MyJVMTest_7914 {

    static byte[] a = { -103, 94, 110, 79, 119, -96, -17, 41, -127, 60 };

    static byte[] b = { 88, -1, 91, -117, 50, -49, -18, 21, 45, -30 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7914().test_cp_unalnsrc(a, b);
    }
}
