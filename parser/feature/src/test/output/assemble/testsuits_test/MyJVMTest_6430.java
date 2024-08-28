public class MyJVMTest_6430 {

    static byte[] a = { 19, -127, 62, -2, -95, -114, 82, -62, -127, 107 };

    byte[] test_ci(byte[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6430().test_ci(a);
    }
}
