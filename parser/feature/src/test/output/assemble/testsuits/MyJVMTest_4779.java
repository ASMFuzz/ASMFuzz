public class MyJVMTest_4779 {

    static byte[] a = { 61, -44, 26, -11, -33, -21, 46, 79, 27, 35 };

    static byte[] b = { 29, -7, -62, -56, 1, -17, -19, -123, 69, 75 };

    static int[] c = { 4, 6, 957271276, 2, 0, 1280951858, 2, 1, 344122336, 7 };

    static int[] d = { 4, 4, 1665997757, 0, 0, 9, 1844294720, 3, 8, 751991018 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4779().test_cp_unalndst(a, b, c, d);
    }
}
