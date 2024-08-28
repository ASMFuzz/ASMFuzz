public class MyJVMTest_15916 {

    static byte[] a = { -123, 7, 67, 98, 120, 116, 10, -101, 68, 47 };

    byte[] test_ci(byte[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15916().test_ci(a);
    }
}
