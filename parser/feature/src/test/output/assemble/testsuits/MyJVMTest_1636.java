public class MyJVMTest_1636 {

    static byte[] a = { -103, -55, 20, -91, -55, -72, -72, -52, -8, 28 };

    static int[] b = { -1828624157, 170636536, 767715647, 5, 0, 0, 4, 0, 3, 8 };

    static byte c = 60;

    static int d = -1025841492;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, int[] b, byte c, int d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1636().test_vi_aln(a, b, c, d);
    }
}
