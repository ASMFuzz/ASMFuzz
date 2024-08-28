public class MyJVMTest_17476 {

    static byte[] a = { 13, -90, 66, 125, 11, 89, -21, 127, 55, 101 };

    static byte[] b = { -3, -49, -33, 71, -29, 101, -124, 16, 12, 49 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17476().test_cp_unalnsrc(a, b);
    }
}
