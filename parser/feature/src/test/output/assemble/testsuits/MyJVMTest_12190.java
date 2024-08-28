public class MyJVMTest_12190 {

    static short[] a = { -32768, -21297, -23727, 32767, 0, 32767, -8918, -32768, 32767, 31184 };

    static short[] b = { -32768, -31410, 30820, 8231, -32768, 0, 32767, -32768, -32768, -32768 };

    static int[] c = { 9, 0, 0, -88399359, 0, 0, -1371297539, 7, 5, 0 };

    static int[] d = { -1898182363, 0, 7, 474036962, 4, 1502043457, 3, 0, 0, 0 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12190().test_cp_alndst(a, b, c, d);
    }
}
