public class MyJVMTest_9376 {

    static int[] src = { -671164669, 0, 0, 5, 3, 4, 9, 1176751115, 1915104187, 0 };

    static int[] dst = { 4, 7, 0, 4, 2, 0, 5, -2117309502, 6, 0 };

    static int length = 7;

    int test_helper(int[] dst, int stop) {
        int res = 0;
        for (int i = 0; i < stop; i++) {
            res += dst[i];
        }
        return res;
    }

    static int field = 1;

    int test(int[] src, int[] dst, int length) {
        field = 4 << 17;
        System.arraycopy(src, 0, dst, 0, length);
        int stop = field >>> 17;
        return test_helper(dst, stop);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9376().test(src, dst, length));
    }
}
