public class MyJVMTest_352 {

    static byte[] a = { -47, -51, 126, -127, 73, -30, -85, 51, 47, -55 };

    static byte[] b = { -69, 49, 30, 70, 72, -4, 22, 62, 68, -63 };

    static short[] c = { 18633, 0, -32768, -17629, 0, 0, -32768, -32768, 12524, -32768 };

    static short[] d = { -14316, 0, 0, -32768, 0, -32768, -1411, -9043, -22973, -32768 };

    byte[] test_cp(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_352().test_cp(a, b, c, d);
    }
}
