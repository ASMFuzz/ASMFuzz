public class MyJVMTest_17775 {

    static int[] dst = { 0, 1, 0, 8, -1079730083, 2572302, 7, 0, 0, 3 };

    static int stop = 0;

    int test_helper(int[] dst, int stop) {
        int res = 0;
        for (int i = 0; i < stop; i++) {
            res += dst[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17775().test_helper(dst, stop));
    }
}
