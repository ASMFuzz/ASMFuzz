public class MyJVMTest_6446 {

    static byte[] a = { -12, -85, 24, 7, 127, 120, -65, -109, -65, 105 };

    static short[] b = { 0, 0, 0, 32767, 0, 0, 32767, -32768, -28843, 32767 };

    byte[] test_ci_oppos(byte[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6446().test_ci_oppos(a, b);
    }
}
