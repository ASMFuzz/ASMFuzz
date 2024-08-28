public class MyJVMTest_1789 {

    static short[] a = { 1780, 32767, 0, -20634, 32767, -13190, -32768, -32768, -32768, 32767 };

    static short b = 11332;

    int test_vi_oppos(short[] a, short b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1789().test_vi_oppos(a, b);
    }
}
