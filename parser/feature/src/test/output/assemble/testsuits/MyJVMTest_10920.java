public class MyJVMTest_10920 {

    static short[] a = { -32768, 0, 32767, -31083, 0, 0, 0, 0, -8567, 32274 };

    static short[] b = { -32768, -15618, 32767, -4510, 6836, 0, 0, 0, 0, 32767 };

    static int[] c = { 6, 0, 6, 9, 0, -895348042, -2047176375, 8, 0, 0 };

    static int[] d = { 0, 0, 6, 0, 0, 9, 0, 7, 474009846, 0 };

    short[] test_cp(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10920().test_cp(a, b, c, d);
    }
}
