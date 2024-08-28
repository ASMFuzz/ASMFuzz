public class MyJVMTest_13124 {

    static byte[] a = { 11, 124, 2, 81, 85, -100, -85, 26, -64, 87 };

    static byte[] b = { -70, 83, -6, 14, 47, 68, 15, -16, -91, -9 };

    static short[] c = { 32767, 32767, 0, -32768, 32767, 32767, 20706, 1790, 32767, 32767 };

    static short[] d = { -32768, -32768, 0, 0, 23420, 21749, -11486, 19403, -10104, 19196 };

    byte[] test_cp_oppos(byte[] a, byte[] b, short[] c, short[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13124().test_cp_oppos(a, b, c, d);
    }
}
