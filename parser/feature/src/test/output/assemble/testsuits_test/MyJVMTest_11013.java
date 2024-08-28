public class MyJVMTest_11013 {

    static short[] a = { -14827, -32768, -32768, -16456, 32767, 32767, -32768, 0, 0, 5033 };

    static short b = -32768;

    int test_vi_oppos(short[] a, short b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11013().test_vi_oppos(a, b);
    }
}
