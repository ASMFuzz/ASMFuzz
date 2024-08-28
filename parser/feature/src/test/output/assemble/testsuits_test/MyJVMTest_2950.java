public class MyJVMTest_2950 {

    static byte[] a = { 105, -41, -78, -69, -48, 46, 78, -56, -28, -101 };

    static byte[] b = { -51, 86, -122, 113, 10, 105, -92, -119, 24, -91 };

    static int OFFSET = 3;

    byte[] test_cp_off(byte[] a, byte[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2950().test_cp_off(a, b);
    }
}
