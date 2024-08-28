public class MyJVMTest_4605 {

    static short[] a = { 32767, 32767, -2091, 0, 32767, 32767, 0, -32768, -32768, -32768 };

    static short[] b = { 32767, -32768, 32767, 32767, 0, 0, 0, -28495, -14060, 0 };

    static short c = 32767;

    static short d = 5961;

    short[] test_2vi_neg(short[] a, short[] b, short c, short d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4605().test_2vi_neg(a, b, c, d);
    }
}
