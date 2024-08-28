public class MyJVMTest_6100 {

    static byte[] a = { -67, -35, -11, -104, 52, -95, -88, 7, -103, -44 };

    static byte[] b = { -61, -15, 30, -51, 24, -23, 3, -44, -83, -62 };

    static short[] c = { -32768, -29329, -32768, 32767, 16065, 32767, 32767, 32767, -32768, 0 };

    static short[] d = { -23613, -14024, 32767, -30793, -32768, 0, -11384, -32768, 0, 32767 };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, short[] c, short[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6100().test_cp_alnsrc(a, b, c, d);
    }
}
