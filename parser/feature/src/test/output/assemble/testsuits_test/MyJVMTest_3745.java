public class MyJVMTest_3745 {

    static byte[] a = { -80, -58, -21, -36, 38, 1, 26, 89, -111, 2 };

    byte[] test_ci_oppos(byte[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3745().test_ci_oppos(a);
    }
}
