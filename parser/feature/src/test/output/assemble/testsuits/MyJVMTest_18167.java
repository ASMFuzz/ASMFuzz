public class MyJVMTest_18167 {

    static byte[] a = { -8, -70, -57, -122, 41, -96, -51, -100, 13, 11 };

    static byte b = 10;

    int test_vi_oppos(byte[] a, byte b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18167().test_vi_oppos(a, b);
    }
}
