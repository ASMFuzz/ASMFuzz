public class MyJVMTest_15562 {

    static byte[] a = { -61, -15, 127, 61, 6, -34, 84, -58, -45, -83 };

    static byte[] b = { -42, -127, -36, 42, -115, -20, -21, 102, -17, -36 };

    static short[] c = { -29943, -32768, 0, 32767, -28806, 31851, 118, 32767, 32767, -32768 };

    static short[] d = { 32767, -32768, -32768, 0, -32768, 0, 0, -32768, 0, 18930 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15562().test_cp_alnsrc(a, b, c, d);
    }
}
