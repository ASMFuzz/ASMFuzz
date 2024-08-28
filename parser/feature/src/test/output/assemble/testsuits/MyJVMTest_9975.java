public class MyJVMTest_9975 {

    static short[] a = { -25627, 0, 32767, -32768, -9055, 32767, 0, 0, 0, 0 };

    static short[] b = { -32768, 27072, -32768, 10340, 2544, 0, 17198, 32767, 32767, -32768 };

    static int[] c = { 0, -914684351, 1330722830, 0, 0, 0, 0, 1659177721, 8, 8 };

    static int[] d = { 6, 8, 0, 8, 1, -1505076629, 3, -999181594, 3, 0 };

    short[] test_cp_neg(short[] a, short[] b, int[] c, int[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9975().test_cp_neg(a, b, c, d);
    }
}
