public class MyJVMTest_17016 {

    static byte[] a = { -100, -78, -17, 88, 44, 27, 76, -86, -56, 55 };

    static byte[] b = { -119, -88, 97, -46, -29, 53, 18, 50, 61, 15 };

    byte[] test_2ci_oppos(byte[] a, byte[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17016().test_2ci_oppos(a, b);
    }
}
