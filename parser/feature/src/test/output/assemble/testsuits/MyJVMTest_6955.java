public class MyJVMTest_6955 {

    static byte[] a = { -67, -86, 39, -59, -43, -15, 20, 78, 75, -27 };

    static byte[] b = { 45, -114, 79, -128, -117, -107, 108, 70, -79, 78 };

    static short[] c = { 30753, 0, 4437, 0, 17682, 0, -32768, 32767, -32768, 1147 };

    static short[] d = { 32767, 0, -32768, 0, 0, -32768, 32767, 0, -13420, 32767 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6955().test_cp_alndst(a, b, c, d);
    }
}
