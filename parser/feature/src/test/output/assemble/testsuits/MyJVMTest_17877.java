public class MyJVMTest_17877 {

    static short[] a = { 32767, 0, 0, 32767, 32767, -32768, -32768, 0, 32767, 0 };

    static short[] b = { -13774, 0, 32767, 32767, 0, -32768, -32768, 32767, 0, -32768 };

    static short c = 0;

    static short d = 32767;

    int test_2vi_oppos(short[] a, short[] b, short c, short d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17877().test_2vi_oppos(a, b, c, d);
    }
}
