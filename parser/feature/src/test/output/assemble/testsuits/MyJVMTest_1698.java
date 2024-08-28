public class MyJVMTest_1698 {

    static short[] a = { -6059, -32768, 0, 32767, 6303, 32767, 32767, 32767, 0, 32767 };

    static short[] b = { 0, 31015, 24167, -32768, -32768, 17791, 9108, -32768, -32768, 0 };

    static int[] c = { 4, 0, -1636735792, 9, 2, 0, 6, 0, 1023429025, 3 };

    static int[] d = { 0, 0, 0, -1224044334, 462017233, 0, 0, 4, 6, 0 };

    short[] test_cp(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1698().test_cp(a, b, c, d);
    }
}
