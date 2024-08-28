public class MyJVMTest_10675 {

    static byte[] a = { 125, -92, 53, 102, -1, -3, -121, -108, 41, 4 };

    static byte b = -128;

    static int SCALE = 2;

    byte[] test_vi_scl(byte[] a, byte b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10675().test_vi_scl(a, b);
    }
}
