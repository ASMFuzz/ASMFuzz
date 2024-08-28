public class MyJVMTest_2892 {

    static short[] a = { -32768, -15352, -4151, 32767, -32768, 0, 0, -32768, 32767, 32767 };

    static short[] b = { -32768, -32768, -32768, 32767, 0, 32767, 32767, 4400, -32768, -7608 };

    static int[] c = { 1105488294, 2, -2099609215, 16300082, 9, 4, 1, 2, 9, 0 };

    static int[] d = { 1814078767, 1703696580, 1, -2098108388, 1693998593, 0, -703627251, 3, -237339441, 0 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2892().test_cp_alndst(a, b, c, d);
    }
}
