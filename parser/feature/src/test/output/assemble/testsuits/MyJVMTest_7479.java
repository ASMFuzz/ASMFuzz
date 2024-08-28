public class MyJVMTest_7479 {

    static byte[] a = { -60, -69, 116, -5, 52, 85, -23, -46, -86, -105 };

    static byte[] b = { -102, -38, -37, 10, -44, 97, 49, 42, -111, -45 };

    byte[] test_2ci_oppos(byte[] a, byte[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7479().test_2ci_oppos(a, b);
    }
}
