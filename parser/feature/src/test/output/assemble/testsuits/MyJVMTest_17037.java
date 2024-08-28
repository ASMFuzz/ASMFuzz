public class MyJVMTest_17037 {

    static short[] a = { -32768, -32768, -30265, 32767, 0, 32767, 32767, -32768, 0, 381 };

    static short[] b = { 32767, 27589, -32768, -454, 32767, 32767, 32767, 0, -32768, 0 };

    static int[] c = { 0, 8, 7, 4, 9, 0, 1209257019, 6, 7, 0 };

    static int[] d = { -1563745141, -359354415, 0, 1553665470, 0, 0, 834963837, 0, 9, 6 };

    short[] test_cp_oppos(short[] a, short[] b, int[] c, int[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17037().test_cp_oppos(a, b, c, d);
    }
}
