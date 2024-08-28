public class MyJVMTest_225 {

    static int[] src = { 13630364, 0, 1, 1753021268, 0, -1159644637, 4, 8, -57980393, 0 };

    static int[] dst = { 1, 0, 3, -1968683037, 4, 6, 1, 7, 721141586, 2 };

    static int length = 3;

    int test_helper(int[] dst, int stop) {
        int res = 0;
        for (int i = 0; i < stop; i++) {
            res += dst[i];
        }
        return res;
    }

    static int field = 0;

    int test(int[] src, int[] dst, int length) {
        field = 4 << 17;
        System.arraycopy(src, 0, dst, 0, length);
        int stop = field >>> 17;
        return test_helper(dst, stop);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_225().test(src, dst, length));
    }
}
