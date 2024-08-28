public class MyJVMTest_13084 {

    static byte[] a = { -18, 23, -55, -83, 94, 83, -69, -90, 17, 73 };

    byte[] test_ci_oppos(byte[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13084().test_ci_oppos(a);
    }
}
