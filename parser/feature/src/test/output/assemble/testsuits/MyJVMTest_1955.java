public class MyJVMTest_1955 {

    static short[] a = { -32768, 32767, 32767, 32767, -32768, 0, 0, 0, 0, -32768 };

    static int[] b = { 9, 8, 6, 1, 2056506794, 7, 1984136465, -2055081065, 9, 1 };

    static short c = -12043;

    static int d = 7;

    short[] test_vi_oppos(short[] a, int[] b, short c, int d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1955().test_vi_oppos(a, b, c, d);
    }
}
