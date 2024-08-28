public class MyJVMTest_16466 {

    static byte[] a = { 96, -8, -70, -95, 123, -89, -43, -39, -27, -108 };

    static byte[] b = { -128, 68, -65, -101, 68, -116, 15, 44, -125, -99 };

    static short[] c = { -32768, 32767, 8048, 0, 0, 0, -12383, 0, -16373, 32767 };

    static short[] d = { 32767, -32768, -20462, 0, -32768, 32767, 0, 32767, 30196, 23882 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16466().test_cp_alndst(a, b, c, d);
    }
}
