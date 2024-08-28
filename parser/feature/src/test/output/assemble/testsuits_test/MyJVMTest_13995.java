public class MyJVMTest_13995 {

    static short[] a = { 32767, -32768, 0, 32767, 32767, 32767, -30639, -32768, 0, 6041 };

    static short[] b = { 32767, -18343, 15694, 0, 32767, -32768, -32768, 0, 5301, -6037 };

    static short c = 0;

    static short d = 0;

    short[] test_2vi_neg(short[] a, short[] b, short c, short d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13995().test_2vi_neg(a, b, c, d);
    }
}
