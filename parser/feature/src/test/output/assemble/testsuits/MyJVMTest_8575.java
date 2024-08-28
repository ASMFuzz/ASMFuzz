public class MyJVMTest_8575 {

    static byte[] a = { 4, -89, -59, 61, -72, 27, 34, 44, 34, -49 };

    static byte b = 127;

    int test_vi_oppos(byte[] a, byte b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8575().test_vi_oppos(a, b);
    }
}
