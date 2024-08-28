public class MyJVMTest_8202 {

    static int[] dst = { 853872139, 2, 6, 2083604275, -1714227057, 6, 1, 0, 0, 0 };

    static int stop = 0;

    int test_helper(int[] dst, int stop) {
        int res = 0;
        for (int i = 0; i < stop; i++) {
            res += dst[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8202().test_helper(dst, stop));
    }
}
