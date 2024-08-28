public class MyJVMTest_5547 {

    static byte[] a = { -78, 122, -65, 34, 94, 94, 98, 28, -127, -78 };

    static byte b = 0;

    byte[] test_vi_neg(byte[] a, byte b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5547().test_vi_neg(a, b);
    }
}
