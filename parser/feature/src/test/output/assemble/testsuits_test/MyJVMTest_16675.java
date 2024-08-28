public class MyJVMTest_16675 {

    static byte[] a = { -9, -44, 24, 121, 122, -10, 53, 79, -12, -24 };

    static short[] b = { -28653, -32768, 32767, 32767, 32767, 0, -32768, 19592, -32768, 7921 };

    static byte c = -128;

    static short d = 0;

    byte[] test_vi_oppos(byte[] a, short[] b, byte c, short d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16675().test_vi_oppos(a, b, c, d);
    }
}
