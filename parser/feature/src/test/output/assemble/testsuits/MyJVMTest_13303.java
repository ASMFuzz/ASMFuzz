public class MyJVMTest_13303 {

    static byte[] a = { -13, 29, -69, -1, -98, -62, 19, 74, 2, 94 };

    static short[] b = { 0, 24102, 31916, -230, -32768, 607, 32767, -4312, -32768, 32767 };

    static byte c = 127;

    static short d = 0;

    byte[] test_vi_neg(byte[] a, short[] b, byte c, short d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13303().test_vi_neg(a, b, c, d);
    }
}
