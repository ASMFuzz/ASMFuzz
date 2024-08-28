public class MyJVMTest_2857 {

    static byte[] a = { -40, 73, 63, 87, -82, -113, -45, -122, 18, -20 };

    static short[] b = { -32768, 32767, -32768, -32768, -30175, 0, -9634, -32768, -32768, -32768 };

    byte[] test_ci(byte[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2857().test_ci(a, b);
    }
}
