public class MyJVMTest_7500 {

    static short[] a = { -32768, 0, 32767, -4423, -32768, 32767, -32768, 0, -32768, 8948 };

    static short[] b = { 17672, 32767, 0, 32767, -28438, 0, 11157, 18347, 0, 32767 };

    static int[] c = { 0, 3, 1, 0, 9, 9, 0, 0, 1498465704, 0 };

    static int[] d = { 0, 1, 2, 9, 9, -1353941849, 4, 0, 5, 0 };

    short[] test_cp_oppos(short[] a, short[] b, int[] c, int[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7500().test_cp_oppos(a, b, c, d);
    }
}
